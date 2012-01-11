/**
 * Copyright 2011 Shopzilla.com
 *
 *  Licensed under the Apache License, Version 2.0 (the "License");
 *  you may not use this file except in compliance with the License.
 *  You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License.
 */
package com.shopzilla.api.client.http;

import com.shopzilla.api.client.CatalogAPIClient;
import com.shopzilla.api.client.UrlProvider;
import com.shopzilla.api.client.brand.BizrateUrlProvider;
import com.shopzilla.api.client.model.AttributeModelAdapter;
import com.shopzilla.api.client.model.CatalogResponse;
import com.shopzilla.api.client.model.CatalogResponseModelAdapter;
import com.shopzilla.api.client.model.Category;
import com.shopzilla.api.client.model.CategoryModelAdapter;
import com.shopzilla.api.client.model.ClassificationModelAdapter;
import com.shopzilla.api.client.model.request.AttributeSearchRequest;
import com.shopzilla.api.client.model.request.CategorySearchRequest;
import com.shopzilla.api.client.model.request.ClassificationRequest;
import com.shopzilla.api.client.model.request.ProductSearchRequest;
import com.shopzilla.api.client.model.response.AttributeSearchResponse;
import com.shopzilla.api.client.model.response.CategoryResponse;
import com.shopzilla.api.client.model.response.Classification;
import com.shopzilla.services.catalog.AttributeResponse;
import com.shopzilla.services.catalog.ClassificationResponse;
import com.shopzilla.services.catalog.ProductResponse;
import com.shopzilla.services.catalog.TaxonomyResponse;
import org.springframework.beans.factory.annotation.Required;
import org.springframework.web.client.RestOperations;
import org.springframework.web.util.UriTemplate;

import java.net.URI;
import java.util.List;

/**
 * @author sscanlon
 */
public class RestCatalogAPIClient implements CatalogAPIClient {

    private UrlProvider urlProvider = new BizrateUrlProvider();

    private RestOperations restTemplate;

    public CatalogResponse performSearch(ProductSearchRequest request) {

        UriTemplate uriTemplate = new UriTemplate(urlProvider.getProductServiceURL());
        URI serviceUri = uriTemplate.expand(urlProvider.makeParameterMap(request));

        ProductResponse result = restTemplate.getForObject(serviceUri, ProductResponse.class);

        CatalogResponse toReturn = CatalogResponseModelAdapter.fromCatalogAPI(result);
        toReturn.setServiceUrl(serviceUri.toString());
        return toReturn;
    }

    public AttributeSearchResponse performAttributeSearch(AttributeSearchRequest request) {
        UriTemplate uriTemplate = new UriTemplate(urlProvider.getAttributeServiceURL());
        URI serviceUri = uriTemplate.expand(urlProvider.makeAttributeParameterMap(request));

        AttributeResponse response = restTemplate.getForObject(serviceUri, AttributeResponse.class);
        return AttributeModelAdapter.fromCatalogAPI(response);
    }

    public CategoryResponse performCategorySearch(CategorySearchRequest request) {
        UriTemplate uriTemplate = new UriTemplate(urlProvider.getTaxonomyServiceURL());
        URI serviceUri = uriTemplate.expand(urlProvider.makeCategoryParameterMap(request));

        TaxonomyResponse response = restTemplate.getForObject(serviceUri, TaxonomyResponse.class);

        final List<Category> categories = CategoryModelAdapter.fromCatalogAPI(response);
        final CategoryResponse categoryResponse = new CategoryResponse();
        categoryResponse.setCategories(categories);
        categoryResponse.setServiceUrl(serviceUri.toString());

        return categoryResponse;
    }

    public Classification performClassification(ClassificationRequest request) {
        ClassificationResponse response = restTemplate.getForObject(urlProvider.getClassificationServiceURL(),
                ClassificationResponse.class,
                urlProvider.makeClassificationParameterMap(request));
        return ClassificationModelAdapter.fromCatalogAPI(response);
    }

    @Required
    public void setRestTemplate(RestOperations restTemplate) {
        this.restTemplate = restTemplate;
    }

    public void setUrlProvider(UrlProvider urlProvider) {
        this.urlProvider = urlProvider;
    }
}

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

import org.springframework.beans.factory.annotation.Required;
import org.springframework.web.client.RestOperations;

import com.shopzilla.api.client.CatalogAPIClient;
import com.shopzilla.api.client.ProductSearchRequest;
import com.shopzilla.api.client.ProductUrl;
import com.shopzilla.api.client.model.CatalogResponse;
import com.shopzilla.api.client.model.CatalogResponseModelAdapter;
import com.shopzilla.services.catalog.ProductResponse;

/**
 * @author sscanlon
 * 
 */
public class RestCatalogAPIClient implements CatalogAPIClient {

    private RestOperations restTemplate;

    public CatalogResponse performSearch(ProductSearchRequest request) {

        ProductResponse result = restTemplate.getForObject(ProductUrl.PRODUCT_URL,
                ProductResponse.class,
                ProductUrl.makeParameterMap(request));

        return CatalogResponseModelAdapter.fromCatalogAPI(result);
    }

    @Required
    public void setRestTemplate(RestOperations restTemplate) {
        this.restTemplate = restTemplate;
    }

}

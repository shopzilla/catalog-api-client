/*
 * Copyright 2014 Shopzilla.com
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.shopzilla.api.client;

import com.shopzilla.api.client.model.request.ProductSearchRequest;
import org.springframework.web.client.RestOperations;

import com.shopzilla.api.service.ProductService;
import com.shopzilla.services.catalog.ProductResponse;

public class ProductClient {

    private RestOperations restTemplate;
    private ProductService productService;

    /**
     * Wrapper for retrieveProductResponseList(), made for parsing sets of Products from searches
     * for a particular keyword.
     * 
     * @param apiKey
     * @param publisherId
     * @param searchKeyword
     * @param numResults
     * 
     * @return ProductResponse
     */
    public ProductResponse doProductSearch(String apiKey, String publisherId, String searchKeyword,
            Integer numResults) {

        ProductSearchRequest request = new ProductSearchRequest();
        request.setApiKey(apiKey);
        request.setPublisherId(publisherId);
        request.setKeyword(searchKeyword);
        request.setNumResults(numResults);

        return retrieveProductResponseList(request);

    }

    /**
     * Multi-purpose method for fetching + parsing ProductResponse XML from Shopzilla API
     * 
     * @param ProductSearchRequest
     * 
     * @return ProductResponse
     */
    private ProductResponse retrieveProductResponseList(ProductSearchRequest request) {

        return restTemplate.getForObject(ProductUrl.PRODUCT_URL,
                                         ProductResponse.class,
                                         ProductUrl.makeParameterMap(request));
    }

    public void setRestTemplate(RestOperations restTemplate) {
        this.restTemplate = restTemplate;
    }

    public void setProductService(ProductService productService) {
        this.productService = productService;
    }

}

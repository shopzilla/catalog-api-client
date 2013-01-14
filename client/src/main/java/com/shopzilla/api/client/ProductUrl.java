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
package com.shopzilla.api.client;

import java.util.HashMap;
import java.util.Map;

import com.shopzilla.api.client.model.request.ProductSearchRequest;

/**
 * @author alook
 * @since 3/27/11
 */
public class ProductUrl {

    public static final String PRODUCT_URL = "http://apistage001.sl1.shopzilla.seastg:7046/services/catalog/v1/us/product?"
            +
            "apiKey={apiKey}" +
            "&publisherId={publisherId}" +
            "&placementId={placementId}" +
            "&categoryId={categoryId}" +
            "&keyword={keyword}" +
            "&productId={productId}" +
            "&productIdType={productType}" +
            "&offersOnly={offersOnly}" +
            "&merchantId={merchantId}" +
            "&brandId=&" +
            "biddedOnly=" +
            "&minPrice=" +
            "&maxPrice=" +
            "&minMarkdown=" +
            "&zipCode=" +
            "&freeShipping=" +
            "&start={start}" +
            "&results={numResults}" +
            "&startOffers=0" +
            "&resultsOffers=0" +
            "&sort=relevancy_desc" +
            "&attFilter=" +
            "&showAttributes={showAttributes}" +
            "&showProductAttributes={showProductAttributes}" +
            "&minRelevancyScore=100" +
            "&maxAge=" +
            "&showRawUrl=" +
            "&imageOnly=";

    public static Map<String, ?> makeParameterMap(ProductSearchRequest request) {

        Map<String, Object> parameters = new HashMap<String, Object>();

        parameters.put("apiKey", request.getApiKey());
        parameters.put("publisherId", request.getPublisherId());
        parameters.put("placementId", request.getPlacementId());
        parameters.put("categoryId", request.getCategoryId());
        parameters.put("keyword", request.getKeyword());
        parameters.put("start", request.getStart());
        parameters.put("productType", request.getProductType());
        parameters.put("numResults", request.getNumResults());
        parameters.put("productId", request.getProductId());
        parameters.put("offersOnly", request.getOffersOnly());
        parameters.put("showAttributes", request.isShowAttributes());
        parameters.put("showProductAttributes", request.isShowProductAttributes());
        parameters.put("merchantId", request.getMerchantId());
        
        return parameters;
    }
}

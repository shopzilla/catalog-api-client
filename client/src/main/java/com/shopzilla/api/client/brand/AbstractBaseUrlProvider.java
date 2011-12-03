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
package com.shopzilla.api.client.brand;

import com.shopzilla.api.client.UrlProvider;
import com.shopzilla.api.client.model.request.AttributeSearchRequest;
import com.shopzilla.api.client.model.request.ProductSearchRequest;

import java.util.HashMap;
import java.util.Map;

/**
 * @author sscanlon
 */
public abstract class AbstractBaseUrlProvider implements UrlProvider {

    public Map<String, ?> makeParameterMap(ProductSearchRequest request) {

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
        parameters.put("biddedOnly", request.getBiddedOnly());
        parameters.put("showRawUrl", request.getShowRawMerchantUrl());
        parameters.put("showAttributes", request.isShowAttributes());
        parameters.put("showProductAttributes", request.isShowProductAttributes());
        parameters.put("merchantId", request.getMerchantId());
        parameters.put("imageOnly", request.getImageOnly());
        parameters.put("zipCode", request.getZipCode());
        parameters.put("backfillResults", request.getBackfillResults());
        parameters.put("minRelevancyScore", request.getMinRelevancyScore());

        return parameters;
    }

    public Map<String, ?> makeAttributeParameterMap(AttributeSearchRequest request) {
        Map<String, Object> parameters = new HashMap<String, Object>();

        parameters.put("apiKey", request.getApiKey());
        parameters.put("publisherId", request.getPublisherId());
        parameters.put("placementId", request.getPlacementId());
        parameters.put("attributeId", request.getAttributeId());
        parameters.put("keyword", request.getKeyword());
        parameters.put("resultsAttributeValues", request.getResultsAttributeValues());
        parameters.put("numResults", request.getNumResults());
        parameters.put("rfCode", request.getRfCode());
        parameters.put("categoryId", request.getCategoryId());

        return parameters;
    }

}

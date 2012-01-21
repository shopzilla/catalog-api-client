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
import com.shopzilla.api.client.model.request.CategorySearchRequest;
import com.shopzilla.api.client.model.request.ClassificationRequest;
import com.shopzilla.api.client.model.request.ProductSearchRequest;
import org.apache.commons.lang.BooleanUtils;
import org.apache.commons.lang.ObjectUtils;

import java.util.HashMap;
import java.util.Map;

/**
 * @author sscanlon
 */
public abstract class AbstractBaseUrlProvider implements UrlProvider {

    public String apiBaseUrl = "http://catalog.bizrate.com/services/catalog/v1/api/";

    public static final String PRODUCT_SERVICE_ENDPOINT_NAME = "product/";
    public static final String ATTRIBUTE_SERVICE_ENDPOINT_NAME = "attributes/";
    public static final String BRAND_SERVICE_ENDPOINT_NAME = "brands/";
    public static final String TAXONOMY_SERVICE_ENDPOINT_NAME = "taxonomy/";
    public static final String CLASSIFICATION_SERVICE_ENDPOINT_NAME = "classification/";
    public static final String MERCHANT_SERVICE_ENDPOINT_NAME = "merchantinfo/";

    private static final Integer defaultResults = 10;

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
        if (request.getMinMarkdown() != null) {
            parameters.put("minMarkdown", request.getMinMarkdown());
        } else {
            parameters.put("minMarkdown", "");
        }
        parameters.put("showRedirectInfo", request.getShowRedirectInfo());
        parameters.put("showRawUrl", request.getShowRawMerchantUrl());
        parameters.put("showAttributes", request.isShowAttributes());
        parameters.put("showProductAttributes", request.isShowProductAttributes());
        parameters.put("merchantId", request.getMerchantId());
        parameters.put("imageOnly", request.getImageOnly());
        parameters.put("zipCode", request.getZipCode());
        parameters.put("backfillResults", request.getBackfillResults());
        parameters.put("minRelevancyScore", request.getMinRelevancyScore());
        parameters.put("resultsOffers", request.getResultsOffers());
        parameters.put("attributeId", request.getAttributeId());
        parameters.put("attWeights", request.getAttWeights());
        parameters.put("attFilter", request.getAttFilter());
        parameters.put("freeShipping", request.isFreeShipping());

        if (request.getSort() != null) {
            parameters.put("sort", request.getSort());
        } else {
            parameters.put("sort", "relevancy_desc");
        }
        if (request.getMaxPrice() != null && request.getMinPrice() != null) {
            parameters.put("maxPrice", request.getMaxPrice());
            parameters.put("minPrice", request.getMinPrice());
        } else {
            parameters.put("maxPrice", "");
            parameters.put("minPrice", "");
        }
        if (request.getMaxAge() != null) {
            parameters.put("maxAge", request.getMaxAge());
        } else {
            parameters.put("maxAge", "");
        }
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

    public Map<String, ?> makeClassificationParameterMap(ClassificationRequest request) {
        Map<String, Object> parameters = new HashMap<String, Object>();

        parameters.put("apiKey", request.getApiKey());
        parameters.put("publisherId", request.getPublisherId());
        parameters.put("placementId", request.getPlacementId());
        parameters.put("keyword", request.getKeyword());
        parameters.put("showAll", BooleanUtils.toBooleanDefaultIfNull(request.getShowAll(), Boolean.TRUE));
        parameters.put("format",
                ((ClassificationRequest.Format) ObjectUtils.defaultIfNull(request.getFormat(),
                        ClassificationRequest.Format.XML)).toString().toLowerCase());

        return parameters;
    }

    public Map<String, ?> makeCategoryParameterMap(CategorySearchRequest request) {
        Map<String, Object> parameters = new HashMap<String, Object>();

        parameters.put("apiKey", request.getApiKey());
        parameters.put("publisherId", request.getPublisherId());
        parameters.put("placementId", request.getPlacementId());
        parameters.put("keyword", request.getKeyword());
        parameters.put("categoryId", request.getCategoryId());
        parameters.put("ancestors", request.getAncestors());
        if (request.getResults() == null) {
            parameters.put("results", defaultResults);
        } else {
            parameters.put("results", request.getResults());
        }
        parameters.put("sort", request.getSortOrder());
        parameters.put("attFilter", request.getAttFilter());
        parameters.put("format",
                ((ClassificationRequest.Format) ObjectUtils.defaultIfNull(request.getFormat(),
                        ClassificationRequest.Format.XML)).toString().toLowerCase());

        return parameters;
    }

    public void setApiBaseUrl(String baseUrl) {
        apiBaseUrl = baseUrl;
    }


}

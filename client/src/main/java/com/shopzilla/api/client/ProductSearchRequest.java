/*
 * Copyright 2011 Shopzilla.com
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

/**
 * @author sscanlon
 * 
 */
public class ProductSearchRequest {

    private static final String EMPTY_STRING = "";
    private static final Integer DEFAULT_PLACEMENT_ID = 1;

    public static enum ProductType {
        SZOID, SZPID, MPID, SKU;
    };

    
    private String apiKey;
    private String publisherId;
    
    private String keyword;
    private Integer start = 0;
    private Integer numResults = 25;

    private Integer placementId = DEFAULT_PLACEMENT_ID;
    private String categoryId = EMPTY_STRING;
    private String productId = EMPTY_STRING;
    private Long merchantId;
    
    
    private Boolean offersOnly = Boolean.FALSE;
    private Boolean showAttributes = Boolean.FALSE;
    private Boolean showProductAttributes = Boolean.FALSE;
    
    private ProductType productType;

    public String getApiKey() {
        return apiKey;
    }

    public void setApiKey(String apiKey) {
        this.apiKey = apiKey;
    }

    public String getPublisherId() {
        return publisherId;
    }

    public void setPublisherId(String publisherId) {
        this.publisherId = publisherId;
    }

    public Integer getPlacementId() {
        return placementId;
    }

    public void setPlacementId(Integer placementId) {
        this.placementId = placementId;
    }

    public String getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(String categoryId) {
        this.categoryId = categoryId;
    }

    public String getKeyword() {
        return keyword;
    }

    public void setKeyword(String keyword) {
        this.keyword = keyword;
    }

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public Integer getNumResults() {
        return numResults;
    }

    public void setNumResults(Integer numResults) {
        this.numResults = numResults;
    }

    public Boolean getOffersOnly() {
        return offersOnly;
    }

    public void setOffersOnly(Boolean offersOnly) {
        this.offersOnly = offersOnly;
    }

    public ProductType getProductType() {
        return productType;
    }

    public void setProductType(ProductType productType) {
        this.productType = productType;
    }

    public Boolean isShowAttributes() {
        return showAttributes;
    }

    public void setShowAttributes(Boolean showAttributes) {
        this.showAttributes = showAttributes;
    }

    public Boolean isShowProductAttributes() {
        return showProductAttributes;
    }

    public void setShowProductAttributes(Boolean showProductAttributes) {
        this.showProductAttributes = showProductAttributes;
    }

    public Integer getStart() {
        return start;
    }

    public void setStart(Integer start) {
        this.start = start;
    }

    public Long getMerchantId() {
        return merchantId;
    }

    public void setMerchantId(Long merchantId) {
        this.merchantId = merchantId;
    }

}

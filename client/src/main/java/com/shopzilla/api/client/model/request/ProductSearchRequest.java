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
package com.shopzilla.api.client.model.request;

/**
 * @author sscanlon
 * 
 */
public class ProductSearchRequest extends AbstractSearchRequest {

    private static final String EMPTY_STRING = "";

    public static enum ProductType {
        SZOID, SZPID, MPID, SKU;
    };

    private String keyword;
    private Integer start = 0;
    private Integer numResults = 25;
    private Integer backfillResults = 0;
    private Integer minRelevancyScore = 100;

    private String categoryId = EMPTY_STRING;
    private String productId = EMPTY_STRING;
    private Long merchantId;
    private String zipCode = EMPTY_STRING;
    
    private Boolean imageOnly = Boolean.FALSE;
    private Boolean offersOnly = Boolean.FALSE;
    private Boolean biddedOnly = Boolean.FALSE;
    private Boolean showRawMerchantUrl = Boolean.FALSE;
    private Boolean showAttributes = Boolean.FALSE;
    private Boolean showProductAttributes = Boolean.FALSE;
    
    private ProductType productType;

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

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    public Integer getNumResults() {
        return numResults;
    }

    public void setNumResults(Integer numResults) {
        this.numResults = numResults;
    }

    public Integer getBackfillResults() {
        return backfillResults;
    }

    public void setBackfillResults(Integer backfillResults) {
        this.backfillResults = backfillResults;
    }

    public Integer getMinRelevancyScore() {
        return minRelevancyScore;
    }

    public void setMinRelevancyScore(Integer minRelevancyScore) {
        this.minRelevancyScore = minRelevancyScore;
    }

    public Boolean getImageOnly() {
        return imageOnly;
    }

    public void setImageOnly(Boolean imageOnly) {
        this.imageOnly = imageOnly;
    }

    public Boolean getOffersOnly() {
        return offersOnly;
    }

    public void setOffersOnly(Boolean offersOnly) {
        this.offersOnly = offersOnly;
    }

    public Boolean getBiddedOnly() {
        return biddedOnly;
    }

    public void setBiddedOnly(Boolean biddedOnly) {
        this.biddedOnly = biddedOnly;
    }

    public Boolean getShowRawMerchantUrl() {
        return showRawMerchantUrl;
    }

    public void setShowRawMerchantUrl(Boolean showRawMerchantUrl) {
        this.showRawMerchantUrl = showRawMerchantUrl;
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

    @Override
    public String toString() {
        return "ProductSearchRequest [keyword=" + keyword + ", start=" + start + ", numResults="
                + numResults + ", backfillResults=" + backfillResults + ", minRelevancyScore="
                + minRelevancyScore + ", categoryId=" + categoryId + ", productId=" + productId
                + ", merchantId=" + merchantId + ", zipCode=" + zipCode + ", imageOnly="
                + imageOnly + ", offersOnly=" + offersOnly + ", biddedOnly=" + biddedOnly
                + ", showRawMerchantUrl=" + showRawMerchantUrl + ", showAttributes="
                + showAttributes + ", showProductAttributes=" + showProductAttributes
                + ", productType=" + productType + "]";
    }
}

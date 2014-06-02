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
package com.shopzilla.api.client.model.request;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;

/**
 * @author sscanlon
 * @author jperez
 */
public class ProductSearchRequest extends AbstractSearchRequest {

    public static final String SORT_BY_RELEVANCY = "relevancy_desc";
    public static final String SORT_BY_LOWEST_PRICE = "price_asc";
    public static final String SORT_BY_HIGHEST_PRICE = "price_desc";
    private static final String EMPTY_STRING = "";
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
    private Integer minMarkdown = null;
    private Integer resultsOffers = 0;
    private String attributeId = EMPTY_STRING;
    private String attWeights = EMPTY_STRING;
    private String attFilter = EMPTY_STRING;
    private Long minPrice = 0L;
    private Long maxPrice;
    private Integer maxAge;
    private boolean freeShipping = Boolean.FALSE;
    private boolean showRedirectInfo = Boolean.FALSE;
    private String sort = SORT_BY_RELEVANCY;
    private ProductType productType;
    private String reviews = "aggregate";

    public String getReviews() {
        return reviews;
    }

    public void setReviews(String reviews) {
        this.reviews = reviews;
    }

    public Integer getMinMarkdown() {
        return minMarkdown;
    }

    public void setMinMarkdown(Integer minMarkdown) {
        this.minMarkdown = minMarkdown;
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

    public Integer getResultsOffers() {
        return resultsOffers;
    }

    public void setResultsOffers(Integer resultsOffers) {
        this.resultsOffers = resultsOffers;
    }

    public String getSort() {
        return sort;
    }

    public void setSort(String sort) {
        // Attempt to match up the sorting string to one of the sorting types.
        // If no match, the default sort will be by relevancy.
        if (StringUtils.isNotEmpty(sort)) {
            if (StringUtils.containsIgnoreCase(sort, "price") && StringUtils.containsIgnoreCase(sort, "asc")) {
                this.sort = SORT_BY_LOWEST_PRICE;
            }
            if (StringUtils.containsIgnoreCase(sort, "price") && StringUtils.containsIgnoreCase(sort, "desc")) {
                this.sort = SORT_BY_HIGHEST_PRICE;
            }
        }
    }

    public String getAttributeId() {
        return attributeId;
    }

    public void setAttributeId(String attributeId) {
        this.attributeId = attributeId;
    }

    public String getAttWeights() {
        return attWeights;
    }

    public void setAttWeights(String attWeights) {
        this.attWeights = attWeights;
    }

    public boolean isFreeShipping() {
        return freeShipping;
    }

    public void setFreeShipping(boolean freeShipping) {
        this.freeShipping = freeShipping;
    }

    public Integer getMaxAge() {
        return maxAge;
    }

    public void setMaxAge(Integer maxAge) {
        this.maxAge = maxAge;
    }

    public Long getMaxPrice() {
        return maxPrice;
    }

    public void setMaxPrice(Long maxPrice) {
        this.maxPrice = maxPrice;
    }

    public Long getMinPrice() {
        return minPrice;
    }

    public void setMinPrice(Long minPrice) {
        this.minPrice = minPrice;
    }

    public String getAttFilter() {
        return attFilter;
    }

    public void setAttFilter(String attFilter) {
        this.attFilter = attFilter;
    }

    public boolean getShowRedirectInfo() {
        return showRedirectInfo;
    }

    public void setShowRedirectInfo(boolean showRedirectInfo) {
        this.showRedirectInfo = showRedirectInfo;
    }

    @Override
    public String toString() {
        return "ProductSearchRequest{" +
                "attFilter='" + attFilter + '\'' +
                ", keyword='" + keyword + '\'' +
                ", start=" + start +
                ", numResults=" + numResults +
                ", backfillResults=" + backfillResults +
                ", minRelevancyScore=" + minRelevancyScore +
                ", categoryId='" + categoryId + '\'' +
                ", productId='" + productId + '\'' +
                ", merchantId=" + merchantId +
                ", zipCode='" + zipCode + '\'' +
                ", imageOnly=" + imageOnly +
                ", offersOnly=" + offersOnly +
                ", biddedOnly=" + biddedOnly +
                ", showRawMerchantUrl=" + showRawMerchantUrl +
                ", showAttributes=" + showAttributes +
                ", showProductAttributes=" + showProductAttributes +
                ", minMarkdown=" + minMarkdown +
                ", resultsOffers=" + resultsOffers +
                ", attributeId='" + attributeId + '\'' +
                ", attWeights='" + attWeights + '\'' +
                ", minPrice=" + minPrice +
                ", maxPrice=" + maxPrice +
                ", maxAge=" + maxAge +
                ", freeShipping=" + freeShipping +
                ", sort='" + sort + '\'' +
                ", productType=" + productType +
                ", showRedirectInfo=" + showRedirectInfo +
                '}';
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder()
                .appendSuper(super.hashCode())
                .append(keyword)
                .append(start)
                .append(backfillResults)
                .append(minRelevancyScore)
                .append(categoryId)
                .append(productId)
                .append(merchantId)
                .append(zipCode)
                .append(imageOnly)
                .append(offersOnly)
                .append(biddedOnly)
                .append(showRawMerchantUrl)
                .append(showAttributes)
                .append(showProductAttributes)
                .append(minMarkdown)
                .append(resultsOffers)
                .append(attributeId)
                .append(attWeights)
                .append(attFilter)
                .append(minPrice)
                .append(maxPrice)
                .append(maxAge)
                .append(freeShipping)
                .append(showRedirectInfo)
                .append(sort)
                .append(productType).toHashCode();
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (obj == this) {
            return true;
        }
        if (obj.getClass() != getClass()) {
            return false;
        }
        ProductSearchRequest rhs = (ProductSearchRequest) obj;
        return new EqualsBuilder()
                .appendSuper(super.equals(obj))
                .append(keyword, rhs.keyword)
                .append(start, rhs.start)
                .append(backfillResults, rhs.backfillResults)
                .append(minRelevancyScore, rhs.minRelevancyScore)
                .append(categoryId, rhs.categoryId)
                .append(productId, rhs.productId)
                .append(merchantId, rhs.merchantId)
                .append(zipCode, rhs.zipCode)
                .append(imageOnly, rhs.imageOnly)
                .append(offersOnly, rhs.offersOnly)
                .append(biddedOnly, rhs.biddedOnly)
                .append(showRawMerchantUrl, rhs.showRawMerchantUrl)
                .append(showAttributes, rhs.showAttributes)
                .append(showProductAttributes, rhs.showProductAttributes)
                .append(minMarkdown, rhs.minMarkdown)
                .append(resultsOffers, rhs.resultsOffers)
                .append(attributeId, rhs.attributeId)
                .append(attWeights, rhs.attWeights)
                .append(attFilter, rhs.attFilter)
                .append(minPrice, rhs.minPrice)
                .append(maxPrice, rhs.maxPrice)
                .append(maxAge, rhs.maxAge)
                .append(freeShipping, rhs.freeShipping)
                .append(showRedirectInfo, rhs.showRedirectInfo)
                .append(sort, rhs.sort)
                .append(productType, rhs.productType).isEquals();
    }

    public static enum ProductType {
        SZOID, SZPID, MPID, SKU;
    }


}

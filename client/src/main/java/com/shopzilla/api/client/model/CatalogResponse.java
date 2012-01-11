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
package com.shopzilla.api.client.model;

import com.shopzilla.api.client.model.response.BaseResponse;
import java.util.Collections;
import java.util.List;

/**
 * @author sscanlon
 *
 */
public class CatalogResponse extends BaseResponse {

    private Long totalResults;
    private Long includedResults;

    private Long relevancyScore;


    private List<Attribute> relatedAttributes;
    private List<Product> products = Collections.emptyList();
    private List<Offer> offers = Collections.emptyList();
    private Price minPrice;
    private Price maxPrice;

    public List<Attribute> getRelatedAttributes() {
        return relatedAttributes;
    }

    public void setRelatedAttributes(List<Attribute> relatedAttributes) {
        this.relatedAttributes = relatedAttributes;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

    public List<Offer> getOffers() {
        return offers;
    }

    public void setOffers(List<Offer> offers) {
        this.offers = offers;
    }

    public Long getRelevancyScore() {
        return relevancyScore;
    }

    public void setRelevancyScore(Long relevancyScore) {
        this.relevancyScore = relevancyScore;
    }

    public Long getTotalResults() {
        return totalResults;
    }

    public void setTotalResults(Long totalResults) {
        this.totalResults = totalResults;
    }

    public Price getMaxPrice() {
        return maxPrice;
    }

    public void setMaxPrice(Price maxPrice) {
        this.maxPrice = maxPrice;
    }

    public Price getMinPrice() {
        return minPrice;
    }

    public void setMinPrice(Price minPrice) {
        this.minPrice = minPrice;
    }

    public Long getIncludedResults() {
        return includedResults;
    }

    public void setIncludedResults(Long includedResults) {
        this.includedResults = includedResults;
    }

    @Override
    public String toString() {
        return "CatalogResponse{" +
                "includedResults=" + includedResults +
                ", totalResults=" + totalResults +
                ", relevancyScore=" + relevancyScore +
                ", serviceUrl='" + this.getServiceUrl() + '\'' +
                ", relatedAttributes=" + relatedAttributes +
                ", products=" + products +
                ", offers=" + offers +
                ", minPrice=" + minPrice +
                ", maxPrice=" + maxPrice +
                '}';
    }

}

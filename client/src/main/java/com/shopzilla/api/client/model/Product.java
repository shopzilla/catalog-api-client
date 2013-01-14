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

import java.math.BigDecimal;
import java.util.List;
import com.shopzilla.services.catalog.RatingType;

/**
 * @author sscanlon
 */
public class Product {
    private Long id;
    private Long categoryId;
    private String title;
    private String url;
    private String description;
    private String longDescription;
    private String sku;
    private List<Attribute> attributes;
    private List<Offer> offers;
    private Price minPrice;
    private Price maxPrice;
    private Long storeCount;
    private BigDecimal relevancy;
    private RatingType rating;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Long categoryId) {
        this.categoryId = categoryId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getURL() {
        return url;
    }

    public void setURL(String value) {
        this.url = value;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getLongDescription() {
        return longDescription;
    }

    public void setLongDescription(String longDescription) {
        this.longDescription = longDescription;
    }

    public String getSku() {
        return sku;
    }

    public void setSku(String sku) {
        this.sku = sku;
    }

    public List<Attribute> getAttributes() {
        return attributes;
    }

    public void setAttributes(List<Attribute> attributes) {
        this.attributes = attributes;
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

    public List<Offer> getOffers() {
        return offers;
    }

    public void setOffers(List<Offer> offers) {
        this.offers = offers;
    }

    public BigDecimal getRelevancy() {
        return relevancy;
    }

    public void setRelevancy(BigDecimal relevancy) {
        this.relevancy = relevancy;
    }

    public Long getStoreCount() {
        return storeCount;
    }

    public void setStoreCount(Long storeCount) {
        this.storeCount = storeCount;
    }
   
    public RatingType getRating() {
        return rating;
    }
  
    public void setRating(RatingType rating) {
        this.rating = rating;
    }
}

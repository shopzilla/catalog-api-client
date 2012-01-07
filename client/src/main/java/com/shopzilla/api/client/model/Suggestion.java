/**
 * Copyright (C) 2004 - 2012 Shopzilla, Inc. 
 * All rights reserved. Unauthorized disclosure or distribution is prohibited.
 */
package com.shopzilla.api.client.model;

/**
 * Description of what the class is about
 * 
 * @author Tom Suthanurak
 * 
 * @since Jan 3, 2012
 */
public class Suggestion {
    public static enum SuggestionType {
        SCRUBBER, QUERY_SUGGESTION, QUERY_CLASSIFICATION, EXCLUDE_SCORCHING
    };

    private SuggestionType suggestionType;
    private long numResults;
    private String keyword;
    private Offer offer;
    private Product product;
    private Category category;

    public SuggestionType getSuggestionType() {
        return suggestionType;
    }

    public void setSuggestionType(SuggestionType suggestionType) {
        this.suggestionType = suggestionType;
    }

    public long getNumResults() {
        return numResults;
    }

    public void setNumResults(long numResults) {
        this.numResults = numResults;
    }

    public String getKeyword() {
        return keyword;
    }

    public void setKeyword(String keyword) {
        this.keyword = keyword;
    }

    public Offer getOffer() {
        return offer;
    }

    public void setOffer(Offer offer) {
        this.offer = offer;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }
}

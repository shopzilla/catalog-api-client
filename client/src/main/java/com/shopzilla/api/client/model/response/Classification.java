/**
 * Copyright (C) 2004 - 2012 Shopzilla, Inc. 
 * All rights reserved. Unauthorized disclosure or distribution is prohibited.
 */
package com.shopzilla.api.client.model.response;

import java.util.ArrayList;
import java.util.List;

import com.shopzilla.api.client.model.Suggestion;

/**
 *  
 * @author Tom Suthanurak
 * 
 * @since Jan 3, 2012
 */
public class Classification {

    private String originalKeyword;
    private Boolean mature;
    private List<Suggestion> suggestions;

    public Classification() {
    }

    public String getOriginalKeyword() {
        return originalKeyword;
    }

    public void setOriginalKeyword(String originalKeyword) {
        this.originalKeyword = originalKeyword;
    }

    public Boolean getMature() {
        return mature;
    }

    public void setMature(Boolean mature) {
        this.mature = mature;
    }

    public List<Suggestion> getSuggestions() {
        if (suggestions == null) {
            suggestions = new ArrayList<Suggestion>();
        }
        return suggestions;
    }
}
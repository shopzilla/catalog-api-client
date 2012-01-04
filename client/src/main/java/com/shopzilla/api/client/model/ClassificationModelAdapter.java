/**
 * Copyright (C) 2004 - 2012 Shopzilla, Inc. 
 * All rights reserved. Unauthorized disclosure or distribution is prohibited.
 */
package com.shopzilla.api.client.model;

import java.util.List;

import org.apache.commons.lang.BooleanUtils;

import com.shopzilla.api.client.model.response.Classification;
import com.shopzilla.services.catalog.ClassificationResponse;
import com.shopzilla.services.catalog.QuerySuggestionType;

/**
 * Description of what the class is about
 * 
 * @author Tom Suthanurak
 * 
 * @since Jan 3, 2012
 */
public class ClassificationModelAdapter {
    public static Classification fromCatalogAPI(ClassificationResponse response) {
        final Classification output = new Classification();
        
        if (response.getClassification() != null) {
            output.setOriginalKeyword(response.getClassification().getOriginalKeyword());
            output.setMature(BooleanUtils.toBooleanObject(response.getClassification().getMature()));
            
            setSuggestions(output, response.getClassification().getQuerySuggestions().getQuerySuggestion());
            
            response.getClassification().getQuerySuggestions();
            
        }
        
        return output;
    }
    
    private static void setSuggestions(Classification classification, List<QuerySuggestionType> querySuggestions) {
        if (querySuggestions != null) {
            for (QuerySuggestionType querySuggestion : querySuggestions) {
                Suggestion suggestion = new Suggestion();
                suggestion.setSuggestionType(Suggestion.SuggestionType.valueOf(querySuggestion.getId()));
                suggestion.setKeyword(querySuggestion.getKeyword());
                
                if (querySuggestion.getOffer() != null) {
                    CatalogResponseModelAdapter.convertOffer(querySuggestion.getOffer());
                }
                if (querySuggestion.getProduct() != null) {
                    CatalogResponseModelAdapter.convertProduct(querySuggestion.getProduct());
                }
                
            }
        }
    }
}

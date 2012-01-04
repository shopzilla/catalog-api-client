/**
 * Copyright (C) 2004 - 2012 Shopzilla, Inc. 
 * All rights reserved. Unauthorized disclosure or distribution is prohibited.
 */
package com.shopzilla.api.client.model;

import java.util.List;

import org.apache.commons.lang.BooleanUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.shopzilla.api.client.model.response.Classification;
import com.shopzilla.services.catalog.ClassificationResponse;
import com.shopzilla.services.catalog.QuerySuggestionType;

/**
 * Convert service classification response into API response model.
 * 
 * @author Tom Suthanurak
 * 
 * @since Jan 3, 2012
 */
public class ClassificationModelAdapter {
    
    private static final Log LOG = LogFactory.getLog(ClassificationModelAdapter.class);
    
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
                try {
                    suggestion.setSuggestionType(Suggestion.SuggestionType.valueOf(querySuggestion.getId()));
                } catch (IllegalArgumentException e) {
                    LOG.error("Unable to convert query suggestion type to a known enum, type:"+querySuggestion.getId(), e);
                }
                
                suggestion.setKeyword(querySuggestion.getKeyword());
                
                if (querySuggestion.getOffer() != null) {
                    suggestion.setOffer(CatalogResponseModelAdapter.convertOffer(querySuggestion.getOffer()));
                }
                if (querySuggestion.getProduct() != null) {
                    suggestion.setProduct(CatalogResponseModelAdapter.convertProduct(querySuggestion.getProduct()));
                }
                if (querySuggestion.getCategory() != null) {
                    Category category = new Category();
                    category.setId(querySuggestion.getCategory().getId());
                    category.setName(querySuggestion.getCategory().getName());
                    suggestion.setCategory(category);
                }

                classification.getSuggestions().add(suggestion);
            }
        }
    }
}

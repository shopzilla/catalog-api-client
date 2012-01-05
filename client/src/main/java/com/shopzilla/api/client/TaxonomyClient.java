/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.shopzilla.api.client;

import com.shopzilla.api.client.model.request.CategorySearchRequest;
import com.shopzilla.services.catalog.TaxonomyResponse;
import org.springframework.beans.factory.annotation.Required;
import org.springframework.web.client.RestOperations;

/**
 *
 * @author sachar
 */
public class TaxonomyClient {
    
    private RestOperations restTemplate;
    private UrlProvider urlProvider;
    
    
    /**
     * Wrapper for retrieveProductResponseList(), made for parsing sets of Products from searches
     * for a particular keyword.
     * 
     * @param apiKey
     * @param publisherId
     * @param searchKeyword
     * @param numResults
     * 
     * @return TaxonomyResponse
     */
    public TaxonomyResponse doCategorySearch(String apiKey, String publisherId, String searchKeyword,
            Integer numResults) {
      try {
        CategorySearchRequest request = new CategorySearchRequest();
        request.setApiKey(apiKey);
        request.setPublisherId(publisherId);
        request.setKeyword(searchKeyword);
        request.setAncestors(Boolean.TRUE);
        request.setResults(numResults);
        return retrieveTaxonomyResponseList(request);
      } catch( RuntimeException ex ) {
          ex.printStackTrace();
          return null;
      }
    }

    /**
     * Multi-purpose method for fetching + parsing ProductResponse XML from Shopzilla API
     * 
     * @param ProductSearchRequest
     * 
     * @return ProductResponse
     */
    private TaxonomyResponse retrieveTaxonomyResponseList(CategorySearchRequest request) {

        return restTemplate.getForObject(urlProvider.getTaxonomyServiceURL(),
                                         TaxonomyResponse.class,
                                         urlProvider.makeCategoryParameterMap(request));
    }
    
    @Required
    public void setRestTemplate(RestOperations restTemplate) {
        this.restTemplate = restTemplate;
    }
    @Required
    public void setUrlProvider(UrlProvider urlProvider) {
        this.urlProvider = urlProvider;
    }
    
    
}

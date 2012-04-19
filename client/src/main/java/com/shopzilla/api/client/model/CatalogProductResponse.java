package com.shopzilla.api.client.model;

import com.shopzilla.services.catalog.ProductResponse;

/**
 * @author nbajpai
 */
public class CatalogProductResponse {

    private ProductResponse response;
    
    private String serviceUrl;

    public CatalogProductResponse(ProductResponse result, String serviceUrl) {
        this.response = result;
        this.serviceUrl = serviceUrl;
    }

    public ProductResponse getResponse() {
        return response;
    }

    public void setResponse(ProductResponse response) {
        this.response = response;
    }

    public String getServiceUrl() {
        return serviceUrl;
    }

    public void setServiceUrl(String serviceUrl) {
        this.serviceUrl = serviceUrl;
    }
}

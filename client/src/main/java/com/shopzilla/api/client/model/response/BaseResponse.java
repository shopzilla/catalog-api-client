/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.shopzilla.api.client.model.response;

/**
 *
 * @author sachar
 */
public abstract class BaseResponse {
    private String serviceUrl;

    public String getServiceUrl() {
        return serviceUrl;
    }

    public void setServiceUrl(String serviceUrl) {
        this.serviceUrl = serviceUrl;
    }
}

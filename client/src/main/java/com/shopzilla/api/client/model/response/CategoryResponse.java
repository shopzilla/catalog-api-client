package com.shopzilla.api.client.model.response;

import com.shopzilla.api.client.model.Category;

import java.util.List;

/**
 * @author Praveena Subrahmanyam
 * @since 1/10/12
 */
public class CategoryResponse {
    private List<Category> categories;
    private String serviceUrl;

    public List<Category> getCategories() {
        return categories;
    }

    public void setCategories(List<Category> categories) {
        this.categories = categories;
    }

    public String getServiceUrl() {
        return serviceUrl;
    }

    public void setServiceUrl(String serviceUrl) {
        this.serviceUrl = serviceUrl;
    }
}

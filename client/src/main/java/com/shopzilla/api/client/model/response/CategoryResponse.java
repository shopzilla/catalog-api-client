package com.shopzilla.api.client.model.response;

import com.shopzilla.api.client.model.Category;

import java.util.List;

/**
 * @author Praveena Subrahmanyam
 * @since 1/10/12
 */
public class CategoryResponse extends BaseResponse  {
    private List<Category> categories;

    public List<Category> getCategories() {
        return categories;
    }

    public void setCategories(List<Category> categories) {
        this.categories = categories;
    }

}

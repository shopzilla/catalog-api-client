/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.shopzilla.api.client.model.request;

/**
 *
 * @author sachar
 */
public class CategorySearchRequest extends AbstractSearchRequest {
    
    
    private String keyword;
    private Long categoryId;
    private Boolean ancestors;
    private Integer results;
    private EnumSortOrder sortOrder;
    private String attFilter;

    public Boolean getAncestors() {
        return ancestors;
    }

    public void setAncestors(Boolean ancestors) {
        this.ancestors = ancestors;
    }

    public String getAttFilter() {
        return attFilter;
    }

    public void setAttFilter(String attFilter) {
        this.attFilter = attFilter;
    }

    public Long getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Long categoryId) {
        this.categoryId = categoryId;
    }

    public String getKeyword() {
        return keyword;
    }

    public void setKeyword(String keyword) {
        this.keyword = keyword;
    }

    public Integer getResults() {
        return results;
    }

    public void setResults(Integer results) {
        this.results = results;
    }

    public EnumSortOrder getSortOrder() {
        return sortOrder;
    }

    public void setSortOrder(EnumSortOrder sortOrder) {
        this.sortOrder = sortOrder;
    }
    
}

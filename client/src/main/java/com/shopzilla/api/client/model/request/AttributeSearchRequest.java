/*
 * Copyright 2011 Shopzilla.com
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.shopzilla.api.client.model.request;

/**
 * @
 * author sscanlon
 * 
 */
public class AttributeSearchRequest extends AbstractSearchRequest {

    private static final String EMPTY_STRING = "";

    private String keyword;

    private Integer numResults = 20;
    private Integer resultsAttributeValues = 100;
    private String attributeId;
    private String categoryId;

    public String getKeyword() {
        return keyword;
    }

    public void setKeyword(String keyword) {
        this.keyword = keyword;
    }

    public Integer getNumResults() {
        return numResults;
    }

    public void setNumResults(Integer numResults) {
        this.numResults = numResults;
    }

    public Integer getResultsAttributeValues() {
        return resultsAttributeValues;
    }

    public void setResultsAttributeValues(Integer resultsAttributeValues) {
        this.resultsAttributeValues = resultsAttributeValues;
    }

    public String getAttributeId() {
        return attributeId;
    }

    public void setAttributeId(String attributeId) {
        this.attributeId = attributeId;
    }

    public String getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(String categoryId) {
        this.categoryId = categoryId;
    }

    @Override
    public String toString() {
        return "AttributeSearchRequest{" +
                "apiKey='" + getApiKey() + '\'' +
                ", publisherId='" + getPublisherId() + '\'' +
                ", placementId=" + getPlacementId() +
                ", keyword='" + keyword + '\'' +
                ", numResults=" + numResults +
                ", resultsAttributeValues=" + resultsAttributeValues +
                ", attributeId='" + attributeId + '\'' +
                ", categoryId='" + categoryId + '\'' +
                '}';
    }
}

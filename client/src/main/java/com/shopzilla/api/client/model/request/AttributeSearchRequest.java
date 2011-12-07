/**
 * Copyright 2011 Shopzilla.com
 *
 *  Licensed under the Apache License, Version 2.0 (the "License");
 *  you may not use this file except in compliance with the License.
 *  You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License.
 */
package com.shopzilla.api.client.model.request;

/**
 * Model object for invoking the Attribute Catalog API endpoint
 *
 * @author sscanlon
 * @author eblanco
 * 
 */
public class AttributeSearchRequest extends AbstractSearchRequest {

    private static final int DEFAULT_NUM_RESULTS = 20;
    private static final int DEFAULT_RESULTS_ATTRIBUTE_VALUES = 100;

    private String keyword;
    private Integer numResults = DEFAULT_NUM_RESULTS;
    private Integer resultsAttributeValues = DEFAULT_RESULTS_ATTRIBUTE_VALUES;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;

        AttributeSearchRequest that = (AttributeSearchRequest) o;

        if (attributeId != null ? !attributeId.equals(that.attributeId) : that.attributeId != null) return false;
        if (categoryId != null ? !categoryId.equals(that.categoryId) : that.categoryId != null) return false;
        if (keyword != null ? !keyword.equals(that.keyword) : that.keyword != null) return false;
        if (numResults != null ? !numResults.equals(that.numResults) : that.numResults != null) return false;
        if (resultsAttributeValues != null ? !resultsAttributeValues.equals(that.resultsAttributeValues) : that.resultsAttributeValues != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + (keyword != null ? keyword.hashCode() : 0);
        result = 31 * result + (numResults != null ? numResults.hashCode() : 0);
        result = 31 * result + (resultsAttributeValues != null ? resultsAttributeValues.hashCode() : 0);
        result = 31 * result + (attributeId != null ? attributeId.hashCode() : 0);
        result = 31 * result + (categoryId != null ? categoryId.hashCode() : 0);
        return result;
    }
}

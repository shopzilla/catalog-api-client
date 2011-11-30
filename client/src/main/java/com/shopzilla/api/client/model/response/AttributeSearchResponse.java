/**
 * Copyright (C) 2004 - 2011 Shopzilla, Inc. 
 * All rights reserved. Unauthorized disclosure or distribution is prohibited.
 */
package com.shopzilla.api.client.model.response;

import com.shopzilla.services.catalog.AttributeType;

import java.util.ArrayList;
import java.util.List;

/**
 * @author alook
 * @since 8/3/11
 */
public class AttributeSearchResponse implements SearchResponse {

    private Attributes attributes;

    private Integer includedResults;

    private String metaInfo;

    public Attributes getAttributes() {
        return attributes;
    }

    public void setAttributes(Attributes attributes) {
        this.attributes = attributes;
    }

    public Integer getIncludedResults() {
        return includedResults;
    }

    public void setIncludedResults(Integer includedResults) {
        this.includedResults = includedResults;
    }

    public String getMetaInfo() {
        return metaInfo;
    }

    public void setMetaInfo(String metaInfo) {
        this.metaInfo = metaInfo;
    }

    public Integer getTotalResults() {
        return includedResults;
    }

    public static class Attributes {

        protected List<AttributeType> attribute;

        public List<AttributeType> getAttribute() {
            if (attribute == null) {
                attribute = new ArrayList<AttributeType>();
            }
            return this.attribute;
        }

    }
}

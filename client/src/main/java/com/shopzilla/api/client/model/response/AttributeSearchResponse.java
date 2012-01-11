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
package com.shopzilla.api.client.model.response;

import com.shopzilla.services.catalog.AttributeType;

import java.util.ArrayList;
import java.util.List;

/**
 * @author alook
 * @author eblanco
 *
 * @since 8/3/11
 */
public class AttributeSearchResponse extends BaseResponse implements SearchResponse {

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

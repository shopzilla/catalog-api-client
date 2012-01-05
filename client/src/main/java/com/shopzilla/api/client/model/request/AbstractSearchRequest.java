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
 * Parent for Catalog API search request classes.
 *
 * @author alook
 * @author eblanco
 *
 * @since 9/16/11
 */
public abstract class AbstractSearchRequest implements SearchRequest {

    private static final Integer DEFAULT_PLACEMENT_ID = 1;
    public static enum Format {XML, JSON, JS};
    
    private String apiKey;
    private String publisherId;
    private Integer placementId = DEFAULT_PLACEMENT_ID;
    private String rfCode;
    
    private Format format;
    private String callback;
    
    public String getApiKey() {
        return apiKey;
    }

    public void setApiKey(String apiKey) {
        this.apiKey = apiKey;
    }

    public String getPublisherId() {
        return publisherId;
    }

    public void setPublisherId(String publisherId) {
        this.publisherId = publisherId;
    }

    public String getRfCode() {
        return rfCode;
    }

    public void setRfCode(String rfCode) {
        this.rfCode = rfCode;
    }

    public Integer getPlacementId() {
        return placementId;
    }

    public void setPlacementId(Integer placementId) {
        this.placementId = placementId;
    }
    
    public Format getFormat() {
        return format;
    }

    public void setFormat(Format format) {
        this.format = format;
    }

    public String getCallback() {
        return callback;
    }

    public void setCallback(String callback) {
        this.callback = callback;
    }
    
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        AbstractSearchRequest that = (AbstractSearchRequest) o;

        if (apiKey != null ? !apiKey.equals(that.apiKey) : that.apiKey != null) return false;
        if (placementId != null ? !placementId.equals(that.placementId) : that.placementId != null) return false;
        if (publisherId != null ? !publisherId.equals(that.publisherId) : that.publisherId != null) return false;
        if (rfCode != null ? !rfCode.equals(that.rfCode) : that.rfCode != null) return false;
        if (format != null ? !format.equals(that.format) : that.format != null) return false;
        if (callback != null ? !callback.equals(that.callback) : that.callback != null) return false;
        
        return true;
    }

    @Override
    public int hashCode() {
        int result = apiKey != null ? apiKey.hashCode() : 0;
        result = 31 * result + (publisherId != null ? publisherId.hashCode() : 0);
        result = 31 * result + (placementId != null ? placementId.hashCode() : 0);
        result = 31 * result + (rfCode != null ? rfCode.hashCode() : 0);
        result = 31 * result + (format != null ? format.hashCode() : 0);
        result = 31 * result + (callback != null ? callback.hashCode() : 0);
        return result;
    }
}

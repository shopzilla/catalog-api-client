/**
 * Copyright (C) 2004 - 2011 Shopzilla, Inc. 
 * All rights reserved. Unauthorized disclosure or distribution is prohibited.
 */
package com.shopzilla.api.client.model.request;

/**
 * @author alook
 * @since 9/16/11
 */
public abstract class AbstractSearchRequest implements SearchRequest {

    private static final Integer DEFAULT_PLACEMENT_ID = 1;

    private String apiKey;
    private String publisherId;
    private Integer placementId = DEFAULT_PLACEMENT_ID;
    private String rfCode;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        AbstractSearchRequest that = (AbstractSearchRequest) o;

        if (apiKey != null ? !apiKey.equals(that.apiKey) : that.apiKey != null) return false;
        if (placementId != null ? !placementId.equals(that.placementId) : that.placementId != null) return false;
        if (publisherId != null ? !publisherId.equals(that.publisherId) : that.publisherId != null) return false;
        if (rfCode != null ? !rfCode.equals(that.rfCode) : that.rfCode != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = apiKey != null ? apiKey.hashCode() : 0;
        result = 31 * result + (publisherId != null ? publisherId.hashCode() : 0);
        result = 31 * result + (placementId != null ? placementId.hashCode() : 0);
        result = 31 * result + (rfCode != null ? rfCode.hashCode() : 0);
        return result;
    }
}

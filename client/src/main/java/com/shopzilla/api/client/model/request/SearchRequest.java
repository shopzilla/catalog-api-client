/**
 * Copyright (C) 2004 - 2011 Shopzilla, Inc. 
 * All rights reserved. Unauthorized disclosure or distribution is prohibited.
 */
package com.shopzilla.api.client.model.request;

/**
 * @author alook
 * @since 9/16/11
 */
public interface SearchRequest {

    public String getApiKey();

    public void setApiKey(String apiKey);

    public String getPublisherId();

    public void setPublisherId(String publisherId);

    public Integer getPlacementId();

    public void setPlacementId(Integer placementId);
}

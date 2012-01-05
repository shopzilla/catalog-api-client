/**
 * Copyright (C) 2004 - 2012 Shopzilla, Inc. 
 * All rights reserved. Unauthorized disclosure or distribution is prohibited.
 */
package com.shopzilla.api.client.model.request;

/**
 * Description of what the class is about
 * 
 * @author Tom Suthanurak
 * 
 * @since Jan 3, 2012
 */
public class ClassificationRequest extends AbstractSearchRequest {
    
    private String keyword;
    private Boolean showAll;
    
    public String getKeyword() {
        return keyword;
    }

    public void setKeyword(String keyword) {
        this.keyword = keyword;
    }

    public Boolean getShowAll() {
        return showAll;
    }

    public void setShowAll(Boolean showAll) {
        this.showAll = showAll;
    }

    
}

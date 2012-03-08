/**
 * Copyright (C) 2004 - 2011 Shopzilla, Inc. 
 * All rights reserved. Unauthorized disclosure or distribution is prohibited.
 */

package com.shopzilla.api.client.model.request;

/**
 * Request class for Merchant service
 *
 * @author Emanuele Blanco
 * @since 06/03/12
 */
public class MerchantRequest extends AbstractSearchRequest {
    
    private String merchantId;

    public String getMerchantId() {
        return merchantId;
    }

    public void setMerchantId(String merchantId) {
        this.merchantId = merchantId;
    }

}

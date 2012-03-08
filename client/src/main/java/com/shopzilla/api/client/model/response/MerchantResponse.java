/**
 * Copyright (C) 2004 - 2011 Shopzilla, Inc. 
 * All rights reserved. Unauthorized disclosure or distribution is prohibited.
 */

package com.shopzilla.api.client.model.response;

import com.shopzilla.api.client.model.MerchantInfo;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

import java.util.List;

/**
 * Response class for Merchant service
 *
 * @author Emanuele Blanco
 * @since 06/03/12
 */
public class MerchantResponse extends BaseResponse {

    private List<MerchantInfo> merchants;

    public List<MerchantInfo> getMerchants() {
        return merchants;
    }

    public void setMerchants(List<MerchantInfo> merchants) {
        this.merchants = merchants;
    }

}

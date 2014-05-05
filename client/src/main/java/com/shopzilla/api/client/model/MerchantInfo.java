/**
 * Copyright 2012 Shopzilla.com
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

package com.shopzilla.api.client.model;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

import java.util.List;
import java.util.ArrayList;
/**
 * Represent a MerchantInfo
 *
 * @author Emanuele Blanco
 * @since 07/03/12
 */
public class MerchantInfo {
    
    private Long id;
    private String name;
    private String url;
    private String merchantUrl;
    private String logoUrl;
    private String countryCode;
    private List<Rating> ratings = new ArrayList<Rating>();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getMerchantUrl() {
        return merchantUrl;
    }

    public void setMerchantUrl(String merchantUrl) {
        this.merchantUrl = merchantUrl;
    }

    public String getLogoUrl() {
        return logoUrl;
    }

    public void setLogoUrl(String logoUrl) {
        this.logoUrl = logoUrl;
    }

    public String getCountryCode() {
        return countryCode;
    }

    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode;
    }

    public List<Rating> getRatings() {
        return ratings;
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder()
                .append(id)
                .append(name)
                .append(url)
                .append(merchantUrl)
                .append(logoUrl)
                .append(countryCode)
                .append(ratings)
                .toHashCode();
    }
    
    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }

        if (obj == null || !(obj instanceof MerchantInfo)) {
            return false;
        }

        MerchantInfo rhs = (MerchantInfo) obj;

        return new EqualsBuilder()
                .append(id, rhs.id)
                .append(name, rhs.name)
                .append(url, rhs.url)
                .append(merchantUrl, rhs.merchantUrl)
                .append(logoUrl, rhs.logoUrl)
                .append(countryCode, rhs.countryCode)
                .append(ratings, rhs.ratings)
                .isEquals();
    }
    
    @Override
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.SHORT_PREFIX_STYLE)
                .append(id)
                .append(name)
                .append(url)
                .append(merchantUrl)
                .append(logoUrl)
                .append(countryCode)
                .append(ratings)
                .toString();
    }
}

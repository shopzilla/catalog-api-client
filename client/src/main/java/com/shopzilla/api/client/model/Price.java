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
package com.shopzilla.api.client.model;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;

/**
 * @author sscanlon
 * 
 */
public class Price {

    private Long integral;
    private String price;

    @Override
    public String toString() {
        return price;
    }

    @Override
    public boolean equals(Object o) {

        if (o == this) {
            return true;
        }

        if (o == null || !(o instanceof Price)) {
            return false;
        }
        Price rhs = (Price) o;

        return new EqualsBuilder()
                .append(integral, rhs.integral)
                .isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder()
                .append(integral)
                .toHashCode();
    }

    public Long getIntegral() {
        return integral;
    }

    public void setIntegral(Long integral) {
        this.integral = integral;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

}

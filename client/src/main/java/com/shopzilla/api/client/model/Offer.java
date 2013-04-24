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

import java.util.List;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;

/**
 * @author sscanlon
 */
public class Offer {

    private Long id;
    private Long mid;
    private Long pid;
    private Price price;
    private Price originalPrice;
    private Price totalPrice;
    private Long categoryId;

    private String title;
    private String description;
    private String manufacturer;
    private String URL;
    private String detailURL;
    private String rawMerchantUrl;
    private String sku;
    private Boolean bidded;
    private Boolean showLogo;
    private String merchantLogoUrl;
    private String shipType;
    private Price shipAmount;
    private Price shipCost;
    private Price tax;
    private String stock;
    private String condition;
    private String bidAmt;
    private boolean mature;
    private Merchant merchant;
    private List<Attribute> attributes;

    @Override
    public String toString() {
        return "Offer{" +
                "bidded=" + bidded +
                ", id=" + id +
                ", mid=" + mid +
                ", pid=" + pid +
                ", price=" + price +
                ", originalPrice=" + originalPrice +
                ", totalPrice=" + totalPrice +
                ", categoryId=" + categoryId +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", URL='" + URL + '\'' +
                ", detailURL='" + detailURL + '\'' +
                ", rawMerchantUrl='" + rawMerchantUrl + '\'' +
                ", sku='" + sku + '\'' +
                ", showLogo=" + showLogo +
	            ", merchantLogoUrl=" + merchantLogoUrl +
                ", shipType='" + shipType + '\'' +
                ", shipAmount=" + shipAmount +
                ", shipCost=" + shipCost +
                ", tax=" + tax +
                ", stock='" + stock + '\'' +
                ", condition='" + condition + '\'' +
                ", merchant=" + merchant +
                ", bidAmt=" + bidAmt +
                ", mature=" + mature +
                '}';
    }


    @Override
    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }

        if (o == null || !(o instanceof Offer)) {
            return false;
        }
        Offer rhs = (Offer) o;
        return new EqualsBuilder()
                .append(id, rhs.id)
                .isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder()
                .append(id)
                .toHashCode();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getMid() {
        return mid;
    }

    public void setMid(Long mid) {
        this.mid = mid;
    }

    public Price getPrice() {
        return price;
    }

    public void setPrice(Price price) {
        this.price = price;
    }

    public Long getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Long categoryId) {
        this.categoryId = categoryId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getURL() {
        return URL;
    }

    public void setURL(String uRL) {
        URL = uRL;
    }

    public String getDetailURL() {
        return detailURL;
    }

    public void setDetailURL(String detailURL) {
        this.detailURL = detailURL;
    }

    public String getRawMerchantUrl() {
        return rawMerchantUrl;
    }

    public void setRawMerchantUrl(String rawMerchantUrl) {
        this.rawMerchantUrl = rawMerchantUrl;
    }

    public Merchant getMerchant() {
        return merchant;
    }

    public void setMerchant(Merchant merchant) {
        this.merchant = merchant;
    }

    public Boolean isBidded() {
        return bidded;
    }

    public void setBidded(Boolean bidded) {
        this.bidded = bidded;
    }

    public String getSku() {
        return sku;
    }

    public void setSku(String sku) {
        this.sku = sku;
    }

    public Boolean getShowLogo() {
        return showLogo;
    }

    public void setShowLogo(Boolean showLogo) {
        this.showLogo = showLogo;
    }

    public Price getShipAmount() {
        return shipAmount;
    }

    public void setShipAmount(Price shipAmount) {
        this.shipAmount = shipAmount;
    }

    public String getShipType() {
        return shipType;
    }

    public void setShipType(String shipType) {
        this.shipType = shipType;
    }

    public String getCondition() {
        return condition;
    }

    public void setCondition(String condition) {
        this.condition = condition;
    }

    public Price getOriginalPrice() {
        return originalPrice;
    }

    public void setOriginalPrice(Price originalPrice) {
        this.originalPrice = originalPrice;
    }

    public Price getShipCost() {
        return shipCost;
    }

    public void setShipCost(Price shipCost) {
        this.shipCost = shipCost;
    }

    public String getStock() {
        return stock;
    }

    public void setStock(String stock) {
        this.stock = stock;
    }

    public Price getTax() {
        return tax;
    }

    public void setTax(Price tax) {
        this.tax = tax;
    }

    public Price getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(Price totalPrice) {
        this.totalPrice = totalPrice;
    }

    public String getBidAmt() {
        return bidAmt;
    }

    public void setBidAmt(String bidAmt) {
        this.bidAmt = bidAmt;
    }
    
    public boolean isMature() {
        return mature;
    }

    public void setMature(boolean mature) {
        this.mature = mature;
    }
    
    public Long getPid() {
        return pid;
    }

    public void setPid(Long pid) {
        this.pid = pid;
    }

    public String getMerchantLogoUrl() {
        return merchantLogoUrl;
    }

    public void setMerchantLogoUrl(final String merchantLogoUrl) {
        this.merchantLogoUrl = merchantLogoUrl;
    }

    public List<Attribute> getAttributes() {
        return attributes;
    }


    public void setAttributes(List<Attribute> attributes) {
        this.attributes = attributes;
    }
    
    public String getManufacturer() {
        return manufacturer;
    } 

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }	    
}

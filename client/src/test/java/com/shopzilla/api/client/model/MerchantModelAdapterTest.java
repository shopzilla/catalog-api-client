/**
 * Copyright (C) 2004 - 2011 Shopzilla, Inc. 
 * All rights reserved. Unauthorized disclosure or distribution is prohibited.
 */

package com.shopzilla.api.client.model;

import com.shopzilla.api.client.model.response.MerchantResponse;
import com.shopzilla.services.catalog.MerchInfoType;
import com.shopzilla.services.catalog.MerchantsResponse;
import org.apache.commons.lang.StringUtils;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertTrue;

/**
 * @author Emanuele Blanco
 * @since 07/03/12
 */
public class MerchantModelAdapterTest {

    @Test
    public void testFromCatalogAPI() throws Exception {
        MerchantsResponse input = generateInput();
        MerchantResponse expectedOutput = generateExpectedOutput();
        assertTrue(areEquals(expectedOutput, MerchantModelAdapter.fromCatalogAPI(input)));
    }

    private MerchantsResponse generateInput() {
        MerchantsResponse response = new MerchantsResponse();
        MerchantsResponse.Merchant merchant = new MerchantsResponse.Merchant();
        merchant.setMid(123L);
        MerchInfoType merchantInfo = new MerchInfoType();
        merchant.setMerchantInfo(merchantInfo);
        merchantInfo.setCountryCode("US");
        merchantInfo.setLogoUrl("logoUrl");
        merchantInfo.setName("name");
        merchantInfo.setUrl("url");
        response.getMerchant().add(merchant);
        return response;
    }

    private MerchantResponse generateExpectedOutput() {
        MerchantResponse response = new MerchantResponse();
        List<MerchantInfo> merchantInfos = new ArrayList<MerchantInfo>();
        MerchantInfo merchantInfo = new MerchantInfo();
        merchantInfo.setCountryCode("US");
        merchantInfo.setId(123L);
        merchantInfo.setLogoUrl("logoUrl");
        merchantInfo.setName("name");
        merchantInfo.setUrl("url");
        merchantInfos.add(merchantInfo);
        response.setMerchants(merchantInfos);
        return response;
    }

    private boolean areEquals(MerchantResponse first, MerchantResponse second) {
        if (first == null && second == null) {
            return true;
        }
        if (first == null || second == null) {
            return false;
        }
        if (first == second) {
            return true;
        }
        if (!StringUtils.equals(first.getServiceUrl(), second.getServiceUrl())) {
            return false;
        }
        if (first.getMerchants() == null && second.getMerchants() == null) {
            return true;
        }
        if (first.getMerchants() == null || second.getMerchants() == null) {
            return false;
        }
        if (first.getMerchants() == second.getMerchants()) {
            return true;
        }
        if (first.getMerchants().size() != second.getMerchants().size()) {
            return false;
        }
        for (int i = 0; i < first.getMerchants().size(); i++) {
            if (!areMerchantEquals(first.getMerchants().get(i), second.getMerchants().get(i))) {
                return false;
            }
        }
        return true;
    }

    private boolean areMerchantEquals(MerchantInfo first, MerchantInfo second) {
        if (first == second) {
            return true;
        }
        if (first == null || second == null) {
            return false;
        }
        if (!StringUtils.equals(first.getCountryCode(), second.getCountryCode())) {
            return false;
        }
        if (!StringUtils.equals(first.getLogoUrl(), second.getLogoUrl())) {
            return false;
        }
        if (!StringUtils.equals(first.getName(), second.getName())) {
            return false;
        }
        if (!StringUtils.equals(first.getUrl(), second.getUrl())) {
            return false;
        }
        if (first.getId() != second.getId()) {
            return false;
        }
        return true;

    }


}

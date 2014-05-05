/**
 * Copyright (C) 2004 - 2011 Shopzilla, Inc. 
 * All rights reserved. Unauthorized disclosure or distribution is prohibited.
 */

package com.shopzilla.api.client.model;

import com.shopzilla.api.client.model.response.MerchantResponse;
import com.shopzilla.services.catalog.*;
import org.apache.commons.lang.StringUtils;
import org.junit.Before;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

/**
 * @author Emanuele Blanco
 * @since 07/03/12
 */
public class MerchantModelAdapterTest {

    MerchantsResponse input;

    MerchantResponse expectedResponse;

    @Before
    public void setUp() {
        input = generateInput();
        expectedResponse = generateExpectedOutput();
    }

    @Test
    public void testFromCatalogAPI() throws Exception {
        expectedResponse = generateExpectedOutput();
        assertTrue(areEquals(expectedResponse, MerchantModelAdapter.fromCatalogAPI(input)));
    }

    @Test
    public void testReviews() throws Exception {
        // test merchantRating = null
        MerchantsResponse.Merchant merchant = input.getMerchant().get(0);
        merchant.setMerchantRating(null);
        assertTrue(areEquals(expectedResponse, MerchantModelAdapter.fromCatalogAPI(input)));

        // test ratingType = null
        MerchantsResponse.Merchant.MerchantRating rating = new MerchantsResponse.Merchant.MerchantRating();
        rating.setRating(null);
        merchant.setMerchantRating(rating);
        assertTrue(areEquals(expectedResponse, MerchantModelAdapter.fromCatalogAPI(input)));

        // test dimensionalAverages = null
        MerchRatingType ratingType = new MerchRatingType();
        ratingType.setDimensionalAverages(null);
        rating.setRating(ratingType);
        expectedResponse = generateExpectedOutput();
        assertTrue(areEquals(expectedResponse, MerchantModelAdapter.fromCatalogAPI(input)));

        // test empty dimensionalAverages
        MerchRatingType.DimensionalAverages averages = new MerchRatingType.DimensionalAverages();
        ratingType.setDimensionalAverages(averages);
        expectedResponse = generateExpectedOutput();
        assertTrue(areEquals(expectedResponse, MerchantModelAdapter.fromCatalogAPI(input)));

        // test averages only contains [null]
        averages.getAverage().add(null);
        expectedResponse = generateExpectedOutput();
        assertTrue(areEquals(expectedResponse, MerchantModelAdapter.fromCatalogAPI(input)));

        // test averages includes a result
        Average average = new Average();
        average.setDimension("averageShipping");
        average.setValue(new BigDecimal(4.21));
        average.setMax(10);
        average.setMin(0);
        averages.getAverage().add(average);

        expectedResponse = generateExpectedOutput();
        Rating outputRating = new Rating();
        outputRating.setDimension("averageShipping");
        outputRating.setValue(new BigDecimal(4.21));
        outputRating.setMax(10);
        outputRating.setMin(0);
        expectedResponse.getMerchants().get(0).getRatings().add(outputRating);

        assertTrue(areEquals(expectedResponse, MerchantModelAdapter.fromCatalogAPI(input)));
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
        for (int i = 0; i < first.getRatings().size(); i++) {
            if (!areRatingsEqual(first.getRatings().get(i), second.getRatings().get(i))) {
                return false;
            }
        }
        return true;
    }

    private boolean areRatingsEqual(Rating first, Rating second) {
        if (first == second) {
            return true;
        }
        if (first == null || second == null) {
            return false;
        }
        if (!StringUtils.equals(first.getDimension(), second.getDimension())) {
            return false;
        }
        if (!first.getValue().equals(second.getValue())) {
            return false;
        }
        if (first.getMax() != second.getMax()) {
            return false;
        }
        if (first.getMin() != second.getMin()) {
            return false;
        }
        return true;
    }
}

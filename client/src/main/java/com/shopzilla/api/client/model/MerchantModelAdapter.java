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

import com.shopzilla.api.client.model.response.MerchantResponse;
import com.shopzilla.services.catalog.MerchantsResponse;

import java.util.ArrayList;
import java.util.List;

/**
 * Converts a MerchantsResponse retrieved from Catalog API to a MerchantResponse client bean
 *
 * @author Emanuele Blanco
 * @since 07/03/12
 */
public class MerchantModelAdapter {

    public static MerchantResponse fromCatalogAPI(MerchantsResponse response) {
        final MerchantResponse output = new MerchantResponse();
        output.setMerchants(convertMerchants(response));
        return output;
    }

    private static List<MerchantInfo> convertMerchants(MerchantsResponse response) {
        List<MerchantInfo> merchants = new ArrayList<MerchantInfo>();
        for (MerchantsResponse.Merchant merchant : response.getMerchant()) {
            merchants.add(convertMerchant(merchant));
        }
        return merchants;
    }

    private static MerchantInfo convertMerchant(MerchantsResponse.Merchant merchant) {
        MerchantInfo merchantInfo = new MerchantInfo();
        merchantInfo.setCountryCode(merchant.getMerchantInfo().getCountryCode());
        merchantInfo.setId(merchant.getMid());
        merchantInfo.setLogoUrl(merchant.getMerchantInfo().getLogoUrl());
        merchantInfo.setName(merchant.getMerchantInfo().getName());
        merchantInfo.setUrl(merchant.getMerchantInfo().getUrl());
        return merchantInfo;
    }
}

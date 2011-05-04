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

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.collections.CollectionUtils;

import com.shopzilla.services.catalog.AttributeType;
import com.shopzilla.services.catalog.AttributeType.AttributeValues;
import com.shopzilla.services.catalog.AttributeValueType;
import com.shopzilla.services.catalog.OfferType;
import com.shopzilla.services.catalog.ProductType;
import com.shopzilla.services.catalog.ProductResponse;
import com.shopzilla.services.catalog.ProductResponse.Classification;
import com.shopzilla.services.catalog.ProductResponse.RelatedAttributes;

/**
 * @author sscanlon
 * 
 */
public class CatalogResponseModelAdapter {

    protected CatalogResponseModelAdapter() {
    }

    public static CatalogResponse fromCatalogAPI(ProductResponse result) {

        if (result == null) {
            return null;
        }

        CatalogResponse toReturn = new CatalogResponse();
        Classification classification = result.getClassification();

        if (classification != null) {
            toReturn.setRelevancyScore(classification.getRelevancyScore());
        }

        /*
         * attributes
         */
        RelatedAttributes catalogAttributes = result.getRelatedAttributes();

        if (catalogAttributes != null
                && CollectionUtils.isNotEmpty(catalogAttributes.getAttribute())) {
            ArrayList<Attribute> attributes = new ArrayList<Attribute>(catalogAttributes.getAttribute()
                    .size());
            for (AttributeType a : catalogAttributes.getAttribute()) {
                Attribute attr = new Attribute();
                attr.setId(a.getId());
                attr.setLabel(a.getName());
                AttributeValues catalogValues = a.getAttributeValues();
                if (catalogValues != null
                        && CollectionUtils.isNotEmpty(catalogValues.getAttributeValue())) {
                    ArrayList<AttributeValue> values = new ArrayList<AttributeValue>(catalogValues.getAttributeValue()
                            .size());
                    for (AttributeValueType t : catalogValues.getAttributeValue()) {
                        AttributeValue v = new AttributeValue();
                        v.setLabel(t.getId());
                        v.setValue(t.getName());
                        values.add(v);
                    }
                    attr.setValues(values);
                }
                attributes.add(attr);
            }
            toReturn.setRelatedAttributes(attributes);
        }

        /*
         * offers
         */
        final ArrayList<Offer> offers = new ArrayList<Offer>();
        if (result.getProducts() != null
                && CollectionUtils.isNotEmpty(result.getProducts().getProductOrOffer())) {
            toReturn.setTotalResults(result.getProducts().getTotalResults());
            offers.addAll(convertOffers(result.getProducts().getProductOrOffer()));
        }
        if (result.getOffers() != null && CollectionUtils.isNotEmpty(result.getOffers().getOffer())) {
            toReturn.setTotalResults(result.getOffers().getTotalResults());
            offers.addAll(convertOffers(result.getOffers().getOffer()));
        }
        toReturn.setOffers(offers);

        final ArrayList<Product> products = new ArrayList<Product>();
        if (result.getProducts() != null
                && CollectionUtils.isNotEmpty(result.getProducts().getProductOrOffer())) {
            toReturn.setTotalResults(result.getProducts().getTotalResults());
            products.addAll(convertProducts(result.getProducts().getProductOrOffer()));
        }
        toReturn.setProducts(products);
        
        return toReturn;
    }

    private static List<Offer> convertOffers(List<?> rawOffers) {
        ArrayList<Offer> offers = new ArrayList<Offer>();
        for (Object productOrOffer : rawOffers) {
            if (!(productOrOffer instanceof OfferType)) {
                continue;
            }
            
            OfferType catalogOffer = (OfferType) productOrOffer;
            Offer o = new Offer();
            
            Merchant m = new Merchant();
            m.setId(catalogOffer.getMerchantId());
            m.setName(catalogOffer.getMerchantName());
            o.setMerchant(m);
            
            o.setCategoryId(catalogOffer.getCategoryId());
            o.setId(catalogOffer.getId());
            o.setMid(catalogOffer.getMerchantId());
            
            if (catalogOffer.getPrice() != null) {
                Price p = new Price();
                p.setIntegral(catalogOffer.getPrice().getIntegral());
                p.setPrice(catalogOffer.getPrice().getValue());
                o.setPrice(p);
            }
            o.setTitle(catalogOffer.getTitle());
            o.setDescription(catalogOffer.getDescription());
            o.setURL(catalogOffer.getUrl());
            o.setDetailURL(catalogOffer.getDetailUrl());
            offers.add(o);
        }
        return offers;
    }

    private static List<Product> convertProducts(List<?> rawProducts) {
        ArrayList<Product> products = new ArrayList<Product>();
        for (Object productOrOffer : rawProducts) {
            if (!(productOrOffer instanceof ProductType)) {
                continue;
            }

            ProductType catalogProduct = (ProductType) productOrOffer;
            Product p = new Product();
            p.setTitle(catalogProduct.getTitle());
            p.setURL(catalogProduct.getUrl());
            p.setCategoryId(catalogProduct.getCategoryId());

            products.add(p);
        }
        return products;
    }
}

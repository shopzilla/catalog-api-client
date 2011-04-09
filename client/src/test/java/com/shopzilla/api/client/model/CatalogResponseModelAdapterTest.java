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

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import org.junit.Before;
import org.junit.Test;

import com.shopzilla.services.catalog.AttributeType;
import com.shopzilla.services.catalog.AttributeType.AttributeValues;
import com.shopzilla.services.catalog.AttributeValueType;
import com.shopzilla.services.catalog.OfferType;
import com.shopzilla.services.catalog.PriceType;
import com.shopzilla.services.catalog.ProductResponse;
import com.shopzilla.services.catalog.ProductResponse.Products;
import com.shopzilla.services.catalog.ProductResponse.RelatedAttributes;

/**
 * @author sscanlon
 * 
 */
public class CatalogResponseModelAdapterTest {

    private ProductResponse from;

    @Before
    public void setUp() {
        from = new ProductResponse();
        assertNotNull(new CatalogResponseModelAdapter());
    }

    @Test
    public void testFromCatalogAPIRelevancy() {
        assertNull(CatalogResponseModelAdapter.fromCatalogAPI(null));

        from.setClassification(new ProductResponse.Classification());
        from.getClassification().setRelevancyScore(1L);

        CatalogResponse result = CatalogResponseModelAdapter.fromCatalogAPI(from);
        assertNotNull(result);
        assertEquals(from.getClassification().getRelevancyScore(), result.getRelevancyScore());

    }

    @Test
    public void testFromCatalogAPIOffers() {

        OfferType o = new OfferType();
        o.setCategoryId(5L);
        o.setDescription("desc");
        o.setId(123l);
        o.setMerchantId(321l);
        o.setPrice(new PriceType());
        o.getPrice().setIntegral(1234l);

        from.setProducts(new Products());
        from.getProducts().getProductOrOffer().add(o);
        CatalogResponse result = CatalogResponseModelAdapter.fromCatalogAPI(from);
        assertEquals(result.getOffers().size(), 1);
        Offer converted = result.getOffers().get(0);

        assertEquals(converted.getCategoryId(), (Long) o.getCategoryId());
        assertEquals(converted.getId(), (Long) o.getId());
        assertEquals(converted.getDescription(), o.getDescription());
        assertEquals(converted.getMid(), (Long) o.getMerchantId());
        assertEquals(converted.getURL(), o.getUrl());
        assertEquals(converted.getDetailURL(), o.getDetailUrl());
        assertEquals(converted.getTitle(), o.getTitle());

    }

    @Test
    public void testFromCatalogAPIAttributes() {

        RelatedAttributes attributes = new RelatedAttributes();

        AttributeType attr = new AttributeType();
        attr.setId("id");
        attr.setName("name");
        attr.setAttributeValues(new AttributeValues());
        attributes.getAttribute().add(attr);
        AttributeValueType value = new AttributeValueType();
        value.setCount(1L);
        value.setId("vid");
        value.setName("vname");
        attr.getAttributeValues().getAttributeValue().add(value);

        from.setRelatedAttributes(attributes);

        CatalogResponse result = CatalogResponseModelAdapter.fromCatalogAPI(from);

        assertEquals(result.getRelatedAttributes().size(), 1);

        Attribute v = result.getRelatedAttributes().get(0);
        assertEquals(v.getId(), attr.getId());
        assertEquals(v.getLabel(), attr.getName());
        assertEquals(v.getValues().size(), 1);

    }
}

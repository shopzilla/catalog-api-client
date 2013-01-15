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

import com.shopzilla.services.catalog.*;
import com.shopzilla.services.catalog.AttributeType.AttributeValues;
import com.shopzilla.services.catalog.ProductResponse.Products;
import com.shopzilla.services.catalog.ProductResponse.RelatedAttributes;
import org.apache.commons.lang.StringUtils;
import org.junit.Before;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import static java.lang.Boolean.TRUE;
import static org.junit.Assert.*;

/**
 * @author sscanlon
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
	    o.setMerchantLogoUrl("http://merchantLogoUrl.com");

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
	    assertEquals(converted.getMerchantLogoUrl(), o.getMerchantLogoUrl());
        assertFalse(converted.isMature());
    }

    @Test
    public void testFromCatalogAPIProducts() {

        OfferType o = new OfferType();
        o.setCategoryId(5L);
        o.setDescription("desc");
        o.setId(123l);
        o.setMerchantId(321l);
        o.setPrice(new PriceType());
        o.getPrice().setIntegral(1234l);

        ProductType p = new ProductType();
        RatingType rating = new RatingType();
        rating.setValue(new BigDecimal(4));
        p.setTitle("MyProduct");
        p.setUrl("http://my.url/");
        p.setCategoryId(222L);
        p.setId(333L);
        p.setDescription("Description");
        p.setLongDescription("LongDescription");
        p.setSku("sku");
        p.setRating(rating);

        ProductType.Attributes attributes = new ProductType.Attributes();
        AttributeType attributeType = new AttributeType();
        attributeType.setName("Name1");
        attributeType.setId("Id1");


        AttributeValues attributeValues = new AttributeValues();
        AttributeValueType attributeValueType = new AttributeValueType();
        attributeValueType.setName("NameType1");
        attributeValueType.setId("IdType1");
        attributeValues.getAttributeValue().add(attributeValueType);

        attributeType.setAttributeValues(attributeValues);

        attributes.getAttribute().add(attributeType);

        p.setAttributes(attributes);


        from.setProducts(new Products());
        from.getProducts().getProductOrOffer().add(p);
        CatalogResponse result = CatalogResponseModelAdapter.fromCatalogAPI(from);
        assertEquals(result.getProducts().size(), 1);
        Product convertedProduct = result.getProducts().get(0);

        assertEquals(convertedProduct.getId(), (Long) p.getId());
        assertEquals(convertedProduct.getCategoryId(), (Long) p.getCategoryId());
        assertEquals(convertedProduct.getTitle(), p.getTitle());
        assertEquals(convertedProduct.getURL(), p.getUrl());
        assertEquals(convertedProduct.getDescription(), p.getDescription());
        assertEquals(convertedProduct.getLongDescription(), p.getLongDescription());
        assertEquals(convertedProduct.getSku(), p.getSku());
        assertEquals(convertedProduct.getRating(), p.getRating());
        assertTrue(attributesAreEqual(convertedProduct.getAttributes(), p.getAttributes()));
    }


    @Test
    public void testMatureOfferFromCatalogAPI() {
        OfferType o = new OfferType();
        o.setCategoryId(5L);
        o.setDescription("desc");
        o.setId(123l);
        o.setMerchantId(321l);
        o.setPrice(new PriceType());
        o.getPrice().setIntegral(1234l);
	    o.setMerchantLogoUrl("http://merchantLogoUrl.com");
        o.setMature(TRUE);

        from.setProducts(new Products());
        from.getProducts().getProductOrOffer().add(o);
        CatalogResponse result = CatalogResponseModelAdapter.fromCatalogAPI(from);
        assertEquals(result.getOffers().size(), 1);
        Offer converted = result.getOffers().get(0);

        assertTrue(converted.isMature());
    }

    private boolean attributesAreEqual(List<Attribute> attributes, ProductType.Attributes productTypeAttributes) {
        if (attributes == null && productTypeAttributes == null) {
            return true;
        }
        if (attributes == null || productTypeAttributes == null) {
            return false;
        }
        if (productTypeAttributes.getAttribute().size() != attributes.size()) {
            return false;
        }
        for (int i = 0; i < attributes.size(); i++) {
            if (!attributeIsEqual(attributes.get(i), productTypeAttributes.getAttribute().get(i))) {
                return false;
            }
        }
        return true;
    }

    private boolean attributeIsEqual(Attribute attribute, AttributeType attributeType) {
        if (attribute == null && attributeType == null) {
            return true;
        }
        if (attribute == null || attributeType == null) {
            return false;
        }
        if (!StringUtils.equals(attribute.getId(), attributeType.getId())) {
            return false;
        }
        if (!StringUtils.equals(attribute.getLabel(), attributeType.getName())) {
            return false;
        }
        if (!attributeValuesAreEqual(attribute.getValues(), attributeType.getAttributeValues())) {
            return false;
        }
        return true;
    }

    private boolean attributeValuesAreEqual(List<AttributeValue> values, AttributeValues attributeValues) {
        if (values == null && attributeValues == null) {
            return true;
        }
        if (values == null || attributeValues == null) {
            return false;
        }
        if (values.size() != attributeValues.getAttributeValue().size()) {
            return false;
        }
        for (int i = 0; i < values.size(); i++) {
            if (!attributeValueIsEqual(values.get(i), attributeValues.getAttributeValue().get(i))) {
                return false;
            }
        }
        return true;
    }

    private boolean attributeValueIsEqual(AttributeValue attributeValue, AttributeValueType attributeValueType) {
        if (attributeValue == null && attributeValueType == null) {
            return true;
        }
        if (attributeValue == null || attributeValueType == null) {
            return false;
        }
        if (!StringUtils.equals(attributeValue.getId(), attributeValueType.getId())) {
            return false;
        }
        if (!StringUtils.equals(attributeValue.getLabel(), attributeValueType.getName())) {
            return false;
        }
        return true;
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



/**
 * Copyright (C) 2004 - 2011 Shopzilla, Inc. 
 * All rights reserved. Unauthorized disclosure or distribution is prohibited.
 */

package com.shopzilla.api.client.model;

import com.shopzilla.api.client.model.response.AttributeSearchResponse;
import com.shopzilla.services.catalog.AttributeResponse;
import com.shopzilla.services.catalog.AttributeType;
import com.shopzilla.services.catalog.AttributeValueType;
import org.apache.commons.lang.ObjectUtils;
import org.apache.commons.lang.StringUtils;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.List;

import static org.junit.Assert.assertTrue;

/**
 *
 * @author Emanuele Blanco
 * @since 01/12/11
 */
public class AttributeModelAdapterTest {

    @Test
    public void testFromCatalogAPI() throws Exception {
        AttributeResponse attributeResponse = generateAttributeResponse();
        AttributeSearchResponse attributeSearchResponse = AttributeModelAdapter.fromCatalogAPI(attributeResponse);
        assertTrue(responsesAreEqual(generateExpectedAttributeSearchResponse(), attributeSearchResponse));
    }

    private boolean responsesAreEqual(AttributeSearchResponse response, AttributeSearchResponse otherResponse) {
        // there is no equals() on jaxb generated classes...
        if (response == null && otherResponse == null) {
            return true;
        }
        if (response == null || otherResponse == null) {
            return false;
        }
        if (!ObjectUtils.equals(response.getIncludedResults(), otherResponse.getIncludedResults())) {
            return false;
        }
        if (!ObjectUtils.equals(response.getMetaInfo(), otherResponse.getMetaInfo())) {
            return false;
        }
        if (!ObjectUtils.equals(response.getTotalResults(), otherResponse.getTotalResults())) {
            return false;
        }
        if (!areAttributesEquals(response.getAttributes(), otherResponse.getAttributes())) {
            return false;
        }
        return true;
    }

    private boolean areAttributesEquals(AttributeSearchResponse.Attributes attributes, AttributeSearchResponse.Attributes otherAttributes) {
        if (attributes == null && otherAttributes == null) {
            return true;
        }
        if (attributes == null || otherAttributes == null) {
            return false;
        }
        if (attributes.getAttribute() == null && otherAttributes.getAttribute() == null) {
            return true;
        }
        if (attributes.getAttribute() == null || otherAttributes.getAttribute() == null) {
            return false;
        }
        if (attributes.getAttribute().size() != otherAttributes.getAttribute().size()) {
            return false;
        }
        for (int i = 0; i < attributes.getAttribute().size(); i++) {
            if (!areAttributeTypeEqual(attributes.getAttribute().get(i), otherAttributes.getAttribute().get(i))) {
                return false;
            }
        }
        return true;
    }

    private boolean areAttributeTypeEqual(AttributeType attributeType, AttributeType otherAttributeType) {
        if (attributeType == null && otherAttributeType == null) {
            return true;
        }
        if (attributeType == null || otherAttributeType == null) {
            return false;
        }
        if (!StringUtils.equals(attributeType.getId(), otherAttributeType.getId())) {
            return false;
        }
        if (!StringUtils.equals(attributeType.getName(), otherAttributeType.getName())) {
            return false;
        }
        if (attributeType.getAttributeValues() == null && otherAttributeType.getAttributeValues() == null) {
            return true;
        }
        if (attributeType.getAttributeValues() == null || otherAttributeType.getAttributeValues() == null) {
            return false;
        }
        List<AttributeValueType> attributeValueTypes = attributeType.getAttributeValues().getAttributeValue();
        List<AttributeValueType> otherAttributeValueTypes = otherAttributeType.getAttributeValues().getAttributeValue();
        if (attributeValueTypes == null && otherAttributeValueTypes == null) {
            return true;
        }
        if (attributeValueTypes == null || otherAttributeValueTypes == null) {
            return false;
        }
        for (int i = 0; i < attributeValueTypes.size(); i++) {
            if (!areAttributeValueTypeEquals(attributeValueTypes.get(i), otherAttributeValueTypes.get(i))) {
                return false;
            }
        }

        return true;

    }

    private boolean areAttributeValueTypeEquals(AttributeValueType attributeValueType, AttributeValueType otherAttributeValueType) {
        if (attributeValueType == null && otherAttributeValueType == null) {
            return true;
        }
        if (attributeValueType == null || otherAttributeValueType == null) {
            return false;
        }
        if (!StringUtils.equals(attributeValueType.getId(), otherAttributeValueType.getId())) {
            return false;
        }
        if (!StringUtils.equals(attributeValueType.getName(), otherAttributeValueType.getName())) {
            return false;
        }
        if (!ObjectUtils.equals(attributeValueType.getCount(), otherAttributeValueType.getCount())) {
            return false;
        }
        if (!ObjectUtils.equals(attributeValueType.getRelevancy(), otherAttributeValueType.getRelevancy())) {
            return false;
        }
        return true;
    }

    private AttributeResponse generateAttributeResponse() {
        AttributeResponse response = new AttributeResponse();
        response.setIncludedResults(10L);
        AttributeResponse.Attributes attributes = new AttributeResponse.Attributes();
        AttributeType attributeType = new AttributeType();
        attributeType.setId("1");
        attributeType.setName("name 1");
        AttributeType.AttributeValues attributeValues = new AttributeType.AttributeValues();
        AttributeValueType attributeValueType = new AttributeValueType();
        attributeValueType.setId("11");
        attributeValueType.setCount(10L);
        attributeValueType.setName("name 11");
        attributeValueType.setRelevancy(new BigDecimal(11.1));
        attributeValues.getAttributeValue().add(attributeValueType);
        attributeType.setAttributeValues(attributeValues);
        attributes.getAttribute().add(attributeType);
        response.setAttributes(attributes);
        return response;
    }

    private AttributeSearchResponse generateExpectedAttributeSearchResponse() {
        AttributeSearchResponse response = new AttributeSearchResponse();
        response.setIncludedResults(10);
        AttributeSearchResponse.Attributes attributes = new AttributeSearchResponse.Attributes();
        AttributeType attributeType = new AttributeType();
        attributeType.setId("1");
        attributeType.setName("name 1");
        AttributeType.AttributeValues attributeValues = new AttributeType.AttributeValues();
        AttributeValueType attributeValueType = new AttributeValueType();
        attributeValueType.setCount(10L);
        attributeValueType.setId("11");
        attributeValueType.setName("name 11");
        attributeValueType.setRelevancy(new BigDecimal(11.1));
        attributeValues.getAttributeValue().add(attributeValueType);
        attributeType.setAttributeValues(attributeValues);
        attributes.getAttribute().add(attributeType);
        response.setAttributes(attributes);
        return response;
    }
}

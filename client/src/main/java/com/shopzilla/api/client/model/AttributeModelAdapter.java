/**
 * Copyright (C) 2004 - 2011 Shopzilla, Inc. 
 * All rights reserved. Unauthorized disclosure or distribution is prohibited.
 */

package com.shopzilla.api.client.model;

import com.shopzilla.api.client.model.response.AttributeSearchResponse;
import com.shopzilla.services.catalog.AttributeResponse;
import com.shopzilla.services.catalog.AttributeType;

/**
 * TODO: document this class!
 *
 * @author Emanuele Blanco
 * @since 30/11/11
 */
public class AttributeModelAdapter {

    public static AttributeSearchResponse fromCatalogAPI(AttributeResponse result) {

        AttributeSearchResponse attributeSearchResponse = new AttributeSearchResponse();

        attributeSearchResponse.setIncludedResults(result.getIncludedResults().intValue());

        AttributeResponse.Attributes resultAttributes = result.getAttributes();

        if (resultAttributes == null) {
            return attributeSearchResponse;
        }

        AttributeSearchResponse.Attributes attributes = new AttributeSearchResponse.Attributes();
        attributeSearchResponse.setAttributes(attributes);

        for (AttributeType attributeType : resultAttributes.getAttribute()) {
            attributes.getAttribute().add(attributeType);
        }

        return attributeSearchResponse;

    }

}

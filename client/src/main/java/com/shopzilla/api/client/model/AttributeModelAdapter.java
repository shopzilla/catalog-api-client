/*
 * Copyright 2011 Shopzilla.com
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.shopzilla.api.client.model;

import com.shopzilla.api.client.model.response.AttributeSearchResponse;
import com.shopzilla.services.catalog.AttributeResponse;
import com.shopzilla.services.catalog.AttributeType;

/**
 * Adapts a Catalog API response to a client model object.
 *
 * @author Emanuele Blanco
 * @since 30/11/11
 */
public class AttributeModelAdapter {

    public static AttributeSearchResponse fromCatalogAPI(AttributeResponse result) {

        AttributeSearchResponse attributeSearchResponse = new AttributeSearchResponse();

        if (inputIsValid(result)) {
            return attributeSearchResponse;
        }

        AttributeResponse.Attributes resultAttributes = result.getAttributes();

        attributeSearchResponse.setIncludedResults(result.getIncludedResults().intValue());

        AttributeSearchResponse.Attributes attributes = new AttributeSearchResponse.Attributes();
        attributeSearchResponse.setAttributes(attributes);

        for (AttributeType attributeType : resultAttributes.getAttribute()) {
            attributes.getAttribute().add(attributeType);
        }

        return attributeSearchResponse;

    }

    private static boolean inputIsValid(AttributeResponse result) {
        return result == null || result.getAttributes() == null;
    }

}

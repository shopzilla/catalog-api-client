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
package com.shopzilla.api.client;

import com.shopzilla.api.client.model.CatalogResponse;
import com.shopzilla.api.client.model.request.AttributeSearchRequest;
import com.shopzilla.api.client.model.request.CategorySearchRequest;
import com.shopzilla.api.client.model.request.ClassificationRequest;
import com.shopzilla.api.client.model.request.ProductSearchRequest;
import com.shopzilla.api.client.model.response.AttributeSearchResponse;
import com.shopzilla.api.client.model.response.CategoryResponse;
import com.shopzilla.api.client.model.response.Classification;

/**
 * @author sscanlon
 * 
 */
public interface CatalogAPIClient {

    public CatalogResponse performSearch(ProductSearchRequest request);

    public CategoryResponse performCategorySearch(CategorySearchRequest request);

    AttributeSearchResponse performAttributeSearch(AttributeSearchRequest request);

    Classification performClassification(ClassificationRequest request);
}

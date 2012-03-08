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

import java.util.Map;

import com.shopzilla.api.client.model.request.*;

/**
 * @author sscanlon
 */
public interface UrlProvider {

    public String getProductServiceURL();

    public String getTaxonomyServiceURL();

    public String getAttributeServiceURL();
    
    public String getClassificationServiceURL();

    public String getBrandServiceURL();

    public String getMerchantServiceURL();
    
    public Map<String, ?> makeParameterMap(ProductSearchRequest request);
    
    public Map<String, ?> makeCategoryParameterMap(CategorySearchRequest request);

    public Map<String, ?> makeAttributeParameterMap(AttributeSearchRequest request);
    
    public Map<String, ?> makeClassificationParameterMap(ClassificationRequest request);
    
    public Map<String, ?> makeMerchantParameterMap(MerchantRequest request);
}

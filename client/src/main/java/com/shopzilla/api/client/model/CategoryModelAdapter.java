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
import java.util.Collections;
import java.util.List;

import org.apache.commons.collections.CollectionUtils;

import com.shopzilla.services.catalog.CategoriesType;
import com.shopzilla.services.catalog.CategoryType;
import com.shopzilla.services.catalog.TaxonomyResponse;

/**
 * @author sscanlon
 * 
 */
public class CategoryModelAdapter {

    protected CategoryModelAdapter() {
    }

    public static List<Category> fromCatalogAPI(TaxonomyResponse response) {

        if (response == null || response.getTaxonomy() == null) {
            return null;
        }

        return convertChildren(response.getTaxonomy().getCategories());

    }

    private static List<Category> convertChildren(CategoriesType children) {
        
        if (children == null || CollectionUtils.isEmpty(children.getCategory())) {
            return Collections.emptyList();
        }
        
        List<Category> toReturn = new ArrayList<Category>();
        for (CategoryType child : children.getCategory()) {
            toReturn.add(convertCategory(child));
        }
        return toReturn;
    }

    private static Category convertCategory(CategoryType cat) {
        Category category = new Category();
        category.setId(cat.getId());
        category.setName(cat.getName());
        category.setURL(cat.getUrl());
        category.setChildren(convertChildren(cat.getChildren()));
        return category;
    }

}

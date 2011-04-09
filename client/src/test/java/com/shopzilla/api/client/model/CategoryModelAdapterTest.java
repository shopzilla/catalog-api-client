package com.shopzilla.api.client.model;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.apache.commons.collections.CollectionUtils;
import org.junit.Test;

import com.shopzilla.services.catalog.CategoriesType;
import com.shopzilla.services.catalog.CategoryType;
import com.shopzilla.services.catalog.TaxonomyResponse;
import com.shopzilla.services.catalog.TaxonomyResponse.Taxonomy;

public class CategoryModelAdapterTest {

    @Test
    public final void testFromCatalogAPI() {

        assertNotNull(new CategoryModelAdapter());

        assertNull(CategoryModelAdapter.fromCatalogAPI(null));

        TaxonomyResponse response = new TaxonomyResponse();

        assertNull(CategoryModelAdapter.fromCatalogAPI(response));

        Taxonomy taxonomy = new Taxonomy();
        response.setTaxonomy(taxonomy);

        assertNotNull(CategoryModelAdapter.fromCatalogAPI(response));
        CategoriesType categories = new CategoriesType();
        taxonomy.setCategories(categories);

        assertNotNull(CategoryModelAdapter.fromCatalogAPI(response));
        CategoryType category = new CategoryType();

        category.setId(1l);
        category.setName("cname");
        category.setUrl("http://foo");

        categories.getCategory().add(category);

        List<Category> result = CategoryModelAdapter.fromCatalogAPI(response);
        assertTrue(CollectionUtils.isNotEmpty(result));
        
        Category converted = result.get(0);
        assertEquals(converted.getId(), (Long)1L);
        assertEquals(converted.getName(), category.getName());
        assertEquals(converted.getURL(), category.getUrl());
    }

}

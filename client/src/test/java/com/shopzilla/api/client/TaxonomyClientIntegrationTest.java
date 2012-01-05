/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.shopzilla.api.client;

import com.shopzilla.services.catalog.TaxonomyResponse;
import com.shopzilla.api.client.helper.CredentialFactory;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static junit.framework.Assert.assertEquals;

/**
 *
 * @author sachar
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:spring/applicationContext-client-test.xml"})
public class TaxonomyClientIntegrationTest {
    @Autowired
    TaxonomyClient client;

    @Autowired
    CredentialFactory credentialFactory;

    private static String apiKey;
    private static String publisherId;
    private static final String keyword = "ipod";

    private static final Integer THREE_RESULTS = 3;

    TaxonomyResponse taxonomyResponse;

    @Before
    public void setUp() {
        apiKey = credentialFactory.getPublisherApiKey();
        publisherId = credentialFactory.getPublisherId();
    }

    @Test
    public void testClientSuccessfullyParsedTenProducts() {
        taxonomyResponse = client.doCategorySearch(apiKey, publisherId, keyword, THREE_RESULTS);
        assertEquals(THREE_RESULTS, (Integer) taxonomyResponse.getTaxonomy().getCategories().getCategory().size());
    }

}

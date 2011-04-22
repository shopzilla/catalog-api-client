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
package com.shopzilla.api.service;

import com.shopzilla.services.catalog.ProductResponse;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.xml.bind.JAXBException;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import static junit.framework.Assert.assertEquals;

/**
 * @author alook
 * @since 3/27/11
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath:spring/applicationContext-client-test.xml"})
public class ProductServiceIntegrationTest {

    @Autowired
    ProductService productService;

    // Placeholder for the result of XML processing
    ProductResponse productResponse;
    // Placeholder for the result of extracting <product>/<offer> list
    List<Object> productOrOffer;

    @Before
    public void setUp() throws IOException, JAXBException {

        // open our sample file, which is located at src/test/resources/sample-data/product.xml
        InputStream in = new ClassPathResource("sample-data/product.xml").getInputStream();

        // pass the inputStream to the service we want to test, and return an object representing the
        // result of teh XML call
        productResponse = productService.xmlInputStreamToJava(in);

        productOrOffer = productResponse.getProducts().getProductOrOffer();
    }

    // There are 2 <Offer> elements in the sample xml data file
    // There are 8 <Product> elements in the sample xml data file
    @Test
    public void testProductOrOfferListReturned() {
        assertEquals(10, productOrOffer.size());
    }

}

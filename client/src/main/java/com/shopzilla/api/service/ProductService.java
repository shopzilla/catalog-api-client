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
import org.springframework.oxm.Marshaller;
import org.springframework.oxm.Unmarshaller;
import org.springframework.oxm.XmlMappingException;

import javax.xml.bind.JAXBException;
import javax.xml.transform.stream.StreamSource;
import java.io.IOException;
import java.io.InputStream;

/**
 * @author alook
 * @since 3/27/11
 */
public class ProductService {

    private Marshaller marshaller;
    private Unmarshaller unmarshaller;

    public ProductResponse xmlInputStreamToJava(InputStream in) throws IOException, JAXBException {
        try {

            ProductResponse productResponse = (ProductResponse) unmarshaller.unmarshal(new StreamSource(in));
            System.out.println("productResponse = " + productResponse);
            return productResponse;

        } catch (XmlMappingException xme) {
            xme.printStackTrace();
        }
        return null;
    }

    public void setMarshaller(Marshaller marshaller) {
        this.marshaller = marshaller;
    }

    public void setUnmarshaller(Unmarshaller unmarshaller) {
        this.unmarshaller = unmarshaller;
    }
}

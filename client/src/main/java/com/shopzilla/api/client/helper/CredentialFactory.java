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
package com.shopzilla.api.client.helper;

/**
 * Class that looks for the API key and publisher Id in environment variables
 * when the context initializes. Be sure to set the following variables before
 * starting a server:
 *  - PUBLISHER_ID
 *  - PUBLISHER_API_KEY
 *
 * @author alook
 * @since 4/7/11
 */
public class CredentialFactory {
    private String publisherId;
    private String publisherApiKey;

    public CredentialFactory() {
        String id = System.getenv("PUBLISHER_ID");
        String key = System.getenv("PUBLISHER_API_KEY");

        if (key != null && id != null) {
            this.publisherId = id;
            this.publisherApiKey = key;
        } else {
            throw new IllegalArgumentException("No API credentials were provided! "+
                                               "Please set PUBLISHER_ID and PUBLISHER_API_KEY ");
        }
    }

    public String getPublisherId() {
        return publisherId;
    }

    public void setPublisherId(String publisherId) {
        this.publisherId = publisherId;
    }

    public String getPublisherApiKey() {
        return publisherApiKey;
    }

    public void setPublisherApiKey(String publisherApiKey) {
        this.publisherApiKey = publisherApiKey;
    }
}

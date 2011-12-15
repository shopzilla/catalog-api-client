/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.shopzilla.api.client.brand;

/**
 *
 * @author sachar
 */
public class LowpriceshopperUrlProvider extends AbstractBaseUrlProvider {
    
    private static final String LOWPRICESHOPPER_PROFILE_ID = "8";

    private static final String PRODUCT_QUERY_FRAGMENT = "?" +
            "apiKey={apiKey}" +
            "&publisherId={publisherId}" +
            "&placementId={placementId}" +
            "&categoryId={categoryId}" +
            "&keyword={keyword}" +
            "&productId={productId}" +
            "&productIdType={productType}" +
            "&offersOnly={offersOnly}" +
            "&merchantId={merchantId}" +
            "&brandId=&" +
            "biddedOnly={biddedOnly}" +
            "&minPrice=" +
            "&maxPrice=" +
            "&minMarkdown={minMarkdown}" +
            "&zipCode=" +
            "&freeShipping=" +
            "&start={start}" +
            "&results={numResults}" +
            "&backfillResults={backfillResults}" + 
            "&startOffers=0" +
            "&resultsOffers=0" +
            "&sort=relevancy_desc" +
            "&attFilter=" +
            "&showAttributes={showAttributes}" +
            "&showProductAttributes={showProductAttributes}" +
            "&minRelevancyScore=100" +
            "&maxAge=" +
            "&showRawUrl=" +
            "&imageOnly=";

    private static final String ATTRIBUTE_QUERY_FRAGMENT = "?" +
            "apiKey={apiKey}" +
            "&publisherId={publisherId}" +
            "&rfCode={rfCode}" +
            "&placementId={placementId}" +
            "&keyword={keyword}" +
            "&attributeId={attributeId}" +
            "&results={numResults}" +
            "&resultsAttributeValues={resultsAttributeValues}" +
            "&callback=callback";

    private static final String TAXONOMY_QUERY_FRAGMENT = "?" +
            "apiKey={apiKey}" +
            "&publisherId={publisherId}" +
            "&placementId={placementId}" +
            "&categoryId={categoryId}" +
            "&keyword={keyword}" +
            "&ancestors=" +
            "&results=10" +
            "&sort=prob_desc";

    public String getProductServiceURL() {
        return new StringBuilder(apiBaseUrl)
                .append("product/")
                .append(LOWPRICESHOPPER_PROFILE_ID)
                .append(PRODUCT_QUERY_FRAGMENT)
                .toString();
    }

    public String getTaxonomyServiceURL() {
        return new StringBuilder(apiBaseUrl)
                .append("taxonomy/")
                .append(LOWPRICESHOPPER_PROFILE_ID)
                .append(TAXONOMY_QUERY_FRAGMENT)
                .toString();
    }

    public String getAttributeServiceURL() {
        return new StringBuilder(apiBaseUrl)
                .append("attributes/")
                .append(LOWPRICESHOPPER_PROFILE_ID)
                .append(ATTRIBUTE_QUERY_FRAGMENT)
                .toString();
    }

    public String getBrandServiceURL() {
        // TODO Auto-generated method stub
        return null;
    }

    public String getMerchantServiceURL() {
        // TODO Auto-generated method stub
        return null;
    }

}

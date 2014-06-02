package com.shopzilla.api.client.model.request;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * @author jperez
 * @since 5/1/14
 */
public class ProductSearchRequestTest {

    private ProductSearchRequest productSearchRequest;
    private String keyword;
    private Integer start;
    private Integer numResults;
    private Integer backfillResults;
    private Integer minRelevancyScore;
    private String categoryId;
    private String productId;
    private Long merchantId;
    private String zipCode;
    private Boolean imageOnly;
    private Boolean offersOnly;
    private Boolean biddedOnly;
    private Boolean showRawMerchantUrl;
    private Boolean showAttributes;
    private Boolean showProductAttributes;
    private Integer minMarkdown;
    private Integer resultsOffers;
    private String attributeId;
    private String attWeights;
    private String attFilter;
    private Long minPrice;
    private Long maxPrice;
    private Integer maxAge;
    private boolean freeShipping;
    private boolean showRedirectInfo;
    private String sort;
    private ProductSearchRequest.ProductType productType;

    @Before
    public void setUp() {
        productSearchRequest = new ProductSearchRequest();

        keyword = "msi laptop";
        start = 0;
        numResults = 25;
        backfillResults = 0;
        minRelevancyScore = 100;
        categoryId = "1";
        productId = "805";
        merchantId = 111L;
        zipCode = "93033";
        imageOnly = Boolean.FALSE;
        offersOnly = Boolean.FALSE;
        biddedOnly = Boolean.FALSE;
        showRawMerchantUrl = Boolean.FALSE;
        showAttributes = Boolean.FALSE;
        showProductAttributes = Boolean.FALSE;
        minMarkdown = 0;
        resultsOffers = 0;
        attributeId = "";
        attWeights = "";
        attFilter = "";
        minPrice = 0L;
        maxPrice = null;
        maxAge = null;
        freeShipping = Boolean.FALSE;
        showRedirectInfo = Boolean.FALSE;
        sort = ProductSearchRequest.SORT_BY_RELEVANCY;
        productType = ProductSearchRequest.ProductType.SZOID;

        productSearchRequest.setAttFilter(attFilter);
        productSearchRequest.setAttributeId(attributeId);
        productSearchRequest.setAttWeights(attWeights);
        productSearchRequest.setBackfillResults(backfillResults);
        productSearchRequest.setBiddedOnly(biddedOnly);
        productSearchRequest.setCategoryId(categoryId);
        productSearchRequest.setFreeShipping(freeShipping);
        productSearchRequest.setImageOnly(imageOnly);
        productSearchRequest.setKeyword(keyword);
        productSearchRequest.setMaxAge(maxAge);
        productSearchRequest.setMaxPrice(maxPrice);
        productSearchRequest.setMerchantId(merchantId);
        productSearchRequest.setMinMarkdown(minMarkdown);
        productSearchRequest.setMinPrice(minPrice);
        productSearchRequest.setMinRelevancyScore(minRelevancyScore);
        productSearchRequest.setNumResults(numResults);
        productSearchRequest.setOffersOnly(offersOnly);
        productSearchRequest.setProductId(productId);
        productSearchRequest.setProductType(productType);
        productSearchRequest.setResultsOffers(resultsOffers);
        productSearchRequest.setShowAttributes(showAttributes);
        productSearchRequest.setShowProductAttributes(showProductAttributes);
        productSearchRequest.setShowRawMerchantUrl(showRawMerchantUrl);
        productSearchRequest.setShowRedirectInfo(showRedirectInfo);
        productSearchRequest.setStart(start);
        productSearchRequest.setSort(sort);
        productSearchRequest.setZipCode(zipCode);
    }

    @Test
    public void testSort() {
        String sortParam = "priceAscending";
        productSearchRequest.setSort(sortParam);
        assertEquals(ProductSearchRequest.SORT_BY_LOWEST_PRICE, productSearchRequest.getSort());

        sortParam = "priceDescending";
        productSearchRequest.setSort(sortParam);
        assertEquals(ProductSearchRequest.SORT_BY_HIGHEST_PRICE, productSearchRequest.getSort());
    }

}

/**
 * Copyright 2014 Shopzilla.com
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

import com.shopzilla.services.catalog.*;
import com.shopzilla.services.catalog.AttributeType.AttributeValues;
import com.shopzilla.services.catalog.ProductResponse.Classification;
import com.shopzilla.services.catalog.ProductResponse.RelatedAttributes;
import org.apache.commons.collections.CollectionUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * @author sscanlon
 * @author jperez
 */
public class CatalogResponseModelAdapter {

    protected CatalogResponseModelAdapter() {
    }

    public static CatalogResponse fromCatalogAPI(ProductResponse result) {

        if (result == null) {
            return null;
        }

        CatalogResponse toReturn = new CatalogResponse();
        Classification classification = result.getClassification();

        if (classification != null) {
            toReturn.setRelevancyScore(classification.getRelevancyScore());
        }

        /*
         * attributes
         */
        RelatedAttributes catalogAttributes = result.getRelatedAttributes();

        if (catalogAttributes != null
                && CollectionUtils.isNotEmpty(catalogAttributes.getAttribute())) {
            ArrayList<Attribute> attributes = new ArrayList<Attribute>(catalogAttributes.getAttribute()
                    .size());
            for (AttributeType a : catalogAttributes.getAttribute()) {
                Attribute attr = new Attribute();
                attr.setId(a.getId());
                attr.setLabel(a.getName());
                AttributeValues catalogValues = a.getAttributeValues();
                if (catalogValues != null
                        && CollectionUtils.isNotEmpty(catalogValues.getAttributeValue())) {
                    ArrayList<AttributeValue> values = new ArrayList<AttributeValue>(catalogValues.getAttributeValue()
                            .size());
                    for (AttributeValueType t : catalogValues.getAttributeValue()) {
                        AttributeValue v = new AttributeValue();
                        v.setLabel(t.getId());
                        v.setValue(t.getName());
                        values.add(v);
                    }
                    attr.setValues(values);
                }
                attributes.add(attr);
            }
            toReturn.setRelatedAttributes(attributes);
        }

        /*
         * offers
         */
        final ArrayList<Offer> offers = new ArrayList<Offer>();
        if (result.getProducts() != null
                && CollectionUtils.isNotEmpty(result.getProducts().getProductOrOffer())) {
            toReturn.setTotalResults(result.getProducts().getTotalResults());
            toReturn.setIncludedResults(result.getProducts().getIncludedResults());
            final PriceSetType priceSet = result.getProducts().getPriceSet();
            if (priceSet != null) {
                toReturn.setMaxPrice(convertPrice(priceSet.getMaxPrice()));
                toReturn.setMinPrice(convertPrice(priceSet.getMinPrice()));
            }
            offers.addAll(convertOffers(result.getProducts().getProductOrOffer()));
        }
        if (result.getOffers() != null && CollectionUtils.isNotEmpty(result.getOffers().getOffer())) {
            toReturn.setTotalResults(result.getOffers().getTotalResults());
            toReturn.setIncludedResults(result.getOffers().getIncludedResults());
            final PriceSetType priceSet = result.getOffers().getPriceSet();
            if (priceSet != null) {
                toReturn.setMaxPrice(convertPrice(priceSet.getMaxPrice()));
                toReturn.setMinPrice(convertPrice(priceSet.getMinPrice()));
            }
            offers.addAll(convertOffers(result.getOffers().getOffer()));
        }
        toReturn.setOffers(offers);

        final ArrayList<Product> products = new ArrayList<Product>();
        if (result.getProducts() != null
                && CollectionUtils.isNotEmpty(result.getProducts().getProductOrOffer())) {
            toReturn.setTotalResults(result.getProducts().getTotalResults());
            toReturn.setIncludedResults(result.getProducts().getIncludedResults());
            final PriceSetType priceSet = result.getProducts().getPriceSet();
            if (priceSet != null) {
                toReturn.setMaxPrice(convertPrice(priceSet.getMaxPrice()));
                toReturn.setMinPrice(convertPrice(priceSet.getMinPrice()));
            }
            products.addAll(convertProducts(result.getProducts().getProductOrOffer()));
        }
        toReturn.setProducts(products);

        return toReturn;
    }

    public static Offer convertOffer(OfferType catalogOffer) {
        Offer o = new Offer();

        if (catalogOffer != null) {
            Merchant m = new Merchant();
            m.setId(catalogOffer.getMerchantId());
            m.setName(catalogOffer.getMerchantName());
            final RatingType merchantRating = catalogOffer.getMerchantRating();
            if (merchantRating != null) {
                m.setOverallRating(merchantRating.getValue());
            }

            final CertificationType merchantCertification = catalogOffer.getMerchantCertification();
            if (merchantCertification != null && merchantCertification.getLevel() != null) {
                m.setCertification(merchantCertification.getLevel().ordinal() + 1);
            }

            if (catalogOffer.getMerchantLogoUrl() != null) {
                o.setMerchantLogoUrl(catalogOffer.getMerchantLogoUrl());
            }

            o.setMerchant(m);

            o.setShowLogo(catalogOffer.isShowLogo());
            o.setBidAmt(catalogOffer.getBidAmt());
            o.setCategoryId(catalogOffer.getCategoryId());
            o.setId(catalogOffer.getId());
            o.setMid(catalogOffer.getMerchantId());
            o.setPid(catalogOffer.getProductId());
            o.setManufacturer(catalogOffer.getManufacturer());

            if (catalogOffer.isMature() != null) {
                o.setMature(catalogOffer.isMature());
            }
            o.setPrice(convertPrice(catalogOffer.getPrice()));
            o.setOriginalPrice(convertPrice(catalogOffer.getOriginalPrice()));
            o.setTotalPrice(convertPrice(catalogOffer.getTotalPrice()));
            o.setTitle(catalogOffer.getTitle());
            o.setDescription(catalogOffer.getDescription());
            o.setURL(catalogOffer.getUrl());
            o.setDetailURL(catalogOffer.getDetailUrl());
            o.setRawMerchantUrl(catalogOffer.getRawUrl());
            o.setSku(catalogOffer.getSku());
            o.setBidded(catalogOffer.isBidded());
            o.setShipAmount(convertPrice(catalogOffer.getShipAmount()));
            o.setShipCost(convertPrice(catalogOffer.getShipCost()));
            o.setShipType(catalogOffer.getShipType());
            o.setTax(convertPrice(catalogOffer.getTax()));
            o.setCondition(catalogOffer.getCondition());
            o.setStock(catalogOffer.getStock());
            OfferType.Attributes attributes = catalogOffer.getAttributes();
            o.setAttributes(convertAttributes(attributes));
            o.setBrand(convertBrand(catalogOffer.getBrand()));

            if (catalogOffer.getAtomId() != null) {
                o.setAtomId(catalogOffer.getAtomId());
            }

        }

        return o;
    }

    public static Price convertPrice(PriceType price) {
        if (price == null) {
            return null;
        }
        Price p = new Price();
        p.setIntegral(price.getIntegral());
        p.setPrice(price.getValue());
        return p;
    }

    private static Attribute convertBrand(BrandType brandType) {
        if (brandType == null) {
            return null;
        }

        Attribute brand = new Attribute();
        brand.setId(String.valueOf(brandType.getId()));
        brand.setLabel(brandType.getName());
        return brand;
    }

    private static List<Attribute> convertAttributes(OfferType.Attributes offerTypeAttributes) {
        if (offerTypeAttributes == null) {
            return null;
        }
        List<AttributeType> attributeTypes = offerTypeAttributes.getAttribute();
        List<Attribute> convertedAttributes = new ArrayList<Attribute>(attributeTypes.size());
        for (AttributeType attributeType : attributeTypes) {
            Attribute attribute = new Attribute();
            attribute.setLabel(attributeType.getName());
            attribute.setId(attributeType.getId());
            attribute.setValues(convertAttributeValues(attributeType.getAttributeValues()));
            convertedAttributes.add(attribute);
        }
        return convertedAttributes;
    }

    public static Product convertProduct(ProductType catalogProduct) {
        Product p = new Product();
        p.setId(catalogProduct.getId());
        p.setCategoryId(catalogProduct.getCategoryId());
        p.setTitle(catalogProduct.getTitle());
        p.setURL(catalogProduct.getUrl());
        p.setDescription(catalogProduct.getDescription());
        p.setLongDescription(catalogProduct.getLongDescription());
        p.setSku(catalogProduct.getSku());
        p.setManufacturer(catalogProduct.getManufacturer());
        p.setAttributes(convertAttributes(catalogProduct.getAttributes()));
        p.setProductReviewCount(catalogProduct.getProductReviewCount());
        final ProductOffersType offers = catalogProduct.getOffers();
        if (offers != null) {
            p.setOffers(convertOffers(offers.getOffer()));
        }
        final PriceSetType priceSet = catalogProduct.getPriceSet();
        if (priceSet != null) {
            if (priceSet.getMaxPrice() != null) {
                p.setMaxPrice(convertPrice(priceSet.getMaxPrice()));
            }
            if (priceSet.getMinPrice() != null) {
                p.setMinPrice(convertPrice(priceSet.getMinPrice()));
            }
            p.setStoreCount(priceSet.getStores());
        }
        p.setRelevancy(catalogProduct.getRelevancy());
        final RatingType rating = catalogProduct.getRating();
        if (rating != null) {
            p.setRating(rating);
        }
        return p;
    }

    private static List<Offer> convertOffers(List<?> rawOffers) {
        ArrayList<Offer> offers = new ArrayList<Offer>();
        for (Object productOrOffer : rawOffers) {
            if (!(productOrOffer instanceof OfferType)) {
                continue;
            }

            OfferType catalogOffer = (OfferType) productOrOffer;
            Offer o = convertOffer(catalogOffer);
            offers.add(o);
        }
        return offers;
    }

    private static List<Product> convertProducts(List<?> rawProducts) {
        ArrayList<Product> products = new ArrayList<Product>();
        for (Object productOrOffer : rawProducts) {
            if (!(productOrOffer instanceof ProductType)) {
                continue;
            }

            ProductType catalogProduct = (ProductType) productOrOffer;
            Product p = convertProduct(catalogProduct);

            products.add(p);
        }
        return products;
    }

    private static List<Attribute> convertAttributes(ProductType.Attributes productTypeAttributes) {
        if (productTypeAttributes == null) {
            return null;
        }
        List<AttributeType> attributeTypes = productTypeAttributes.getAttribute();
        List<Attribute> convertedAttributes = new ArrayList<Attribute>(attributeTypes.size());
        for (AttributeType attributeType : attributeTypes) {
            Attribute attribute = new Attribute();
            attribute.setLabel(attributeType.getName());
            attribute.setId(attributeType.getId());
            attribute.setValues(convertAttributeValues(attributeType.getAttributeValues()));
            convertedAttributes.add(attribute);
        }
        return convertedAttributes;
    }

    private static List<AttributeValue> convertAttributeValues(AttributeValues attributeValues) {
        if (attributeValues == null) {
            return null;
        }
        List<AttributeValueType> attributeValueTypes = attributeValues.getAttributeValue();
        List<AttributeValue> convertedAttributeValues = new ArrayList<AttributeValue>(attributeValueTypes.size());
        for (AttributeValueType attributeValueType : attributeValueTypes) {
            AttributeValue attributeValue = new AttributeValue();
            attributeValue.setLabel(attributeValueType.getName());
            attributeValue.setId(attributeValueType.getId());
            convertedAttributeValues.add(attributeValue);
        }
        return convertedAttributeValues;
    }

}

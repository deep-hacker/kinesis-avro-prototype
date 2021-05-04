/**
 * Autogenerated by Avro
 *
 * DO NOT EDIT DIRECTLY
 */
package com.cj.prototype.avroGenerated;

@org.apache.avro.specific.AvroGenerated
public interface AdvertisablesProtocol {
  public static final org.apache.avro.Protocol PROTOCOL = org.apache.avro.Protocol.parse("{\"protocol\":\"AdvertisablesProtocol\",\"namespace\":\"com.cj.prototype.avroGenerated\",\"types\":[{\"type\":\"record\",\"name\":\"AmountWithCurrency\",\"fields\":[{\"name\":\"amount\",\"type\":[\"null\",\"string\"],\"default\":null},{\"name\":\"currency\",\"type\":[\"null\",\"string\"],\"default\":null}]},{\"type\":\"record\",\"name\":\"GoogleProductCategory\",\"fields\":[{\"name\":\"name\",\"type\":[\"null\",\"string\"],\"default\":null},{\"name\":\"id\",\"type\":[\"null\",\"int\"],\"default\":null}]},{\"type\":\"record\",\"name\":\"Tax\",\"fields\":[{\"name\":\"rate\",\"type\":[\"null\",\"string\"],\"default\":null},{\"name\":\"countryCode\",\"type\":[\"null\",\"string\"],\"default\":null},{\"name\":\"region\",\"type\":[\"null\",\"string\"],\"default\":null},{\"name\":\"postalcode\",\"type\":[\"null\",\"string\"],\"default\":null},{\"name\":\"locationId\",\"type\":[\"null\",\"string\"],\"default\":null},{\"name\":\"locationGroupName\",\"type\":[\"null\",\"string\"],\"default\":null},{\"name\":\"taxShip\",\"type\":[\"null\",\"boolean\"],\"default\":null}]},{\"type\":\"record\",\"name\":\"Shipping\",\"fields\":[{\"name\":\"price\",\"type\":\"AmountWithCurrency\"},{\"name\":\"service\",\"type\":[\"null\",\"string\"],\"default\":null},{\"name\":\"locationGroupName\",\"type\":[\"null\",\"string\"],\"default\":null},{\"name\":\"region\",\"type\":[\"null\",\"string\"],\"default\":null},{\"name\":\"postalCode\",\"type\":[\"null\",\"string\"],\"default\":null},{\"name\":\"locationId\",\"type\":[\"null\",\"string\"],\"default\":null},{\"name\":\"country\",\"type\":[\"null\",\"string\"],\"default\":null},{\"name\":\"weight\",\"type\":[\"null\",\"string\"],\"default\":null},{\"name\":\"length\",\"type\":[\"null\",\"string\"],\"default\":null},{\"name\":\"width\",\"type\":[\"null\",\"string\"],\"default\":null},{\"name\":\"height\",\"type\":[\"null\",\"string\"],\"default\":null}]},{\"type\":\"record\",\"name\":\"Address\",\"fields\":[{\"name\":\"city\",\"type\":[\"null\",\"string\"],\"default\":null},{\"name\":\"provinceState\",\"type\":[\"null\",\"string\"],\"default\":null},{\"name\":\"streetAddress\",\"type\":[\"null\",\"string\"],\"default\":null},{\"name\":\"zipCode\",\"type\":[\"null\",\"string\"],\"default\":null},{\"name\":\"latitude\",\"type\":[\"null\",\"string\"],\"default\":null},{\"name\":\"longitude\",\"type\":[\"null\",\"string\"],\"default\":null},{\"name\":\"regionName\",\"type\":[\"null\",\"string\"],\"default\":null},{\"name\":\"country\",\"type\":[\"null\",\"string\"],\"default\":null},{\"name\":\"phoneNumber\",\"type\":[\"null\",\"string\"],\"default\":null}]},{\"type\":\"record\",\"name\":\"AdditionalFee\",\"fields\":[{\"name\":\"amount\",\"type\":[\"null\",\"AmountWithCurrency\"],\"default\":null},{\"name\":\"id\",\"type\":[\"null\",\"string\"],\"default\":null},{\"name\":\"name\",\"type\":[\"null\",\"string\"],\"default\":null}]},{\"type\":\"record\",\"name\":\"LoyaltyPoints\",\"fields\":[{\"name\":\"name\",\"type\":[\"null\",\"string\"],\"default\":null},{\"name\":\"points\",\"type\":[\"null\",\"int\"],\"default\":null},{\"name\":\"ratio\",\"type\":[\"null\",\"string\"],\"default\":null}]},{\"type\":\"record\",\"name\":\"Installment\",\"fields\":[{\"name\":\"months\",\"type\":[\"null\",\"int\"],\"default\":null},{\"name\":\"amount\",\"type\":[\"null\",\"AmountWithCurrency\"],\"default\":null}]},{\"type\":\"record\",\"name\":\"Product\",\"fields\":[{\"name\":\"additionalImageLink\",\"type\":[\"null\",{\"type\":\"array\",\"items\":\"string\"}],\"default\":null},{\"name\":\"adId\",\"type\":\"string\"},{\"name\":\"advertiserCountry\",\"type\":[\"null\",\"string\"],\"default\":null},{\"name\":\"advertiserId\",\"type\":\"string\"},{\"name\":\"advertiserName\",\"type\":\"string\"},{\"name\":\"brand\",\"type\":[\"null\",\"string\"],\"default\":null},{\"name\":\"catalogId\",\"type\":\"string\"},{\"name\":\"customLabel0\",\"type\":[\"null\",\"string\"],\"default\":null},{\"name\":\"customLabel1\",\"type\":[\"null\",\"string\"],\"default\":null},{\"name\":\"customLabel2\",\"type\":[\"null\",\"string\"],\"default\":null},{\"name\":\"customLabel3\",\"type\":[\"null\",\"string\"],\"default\":null},{\"name\":\"customLabel4\",\"type\":[\"null\",\"string\"],\"default\":null},{\"name\":\"description\",\"type\":\"string\"},{\"name\":\"id\",\"type\":\"string\"},{\"name\":\"imageLink\",\"type\":[\"null\",\"string\"],\"default\":null},{\"name\":\"itemListId\",\"type\":[\"null\",\"string\"],\"default\":null},{\"name\":\"itemListName\",\"type\":[\"null\",\"string\"],\"default\":null},{\"name\":\"lastUpdated\",\"type\":\"long\"},{\"name\":\"link\",\"type\":[\"null\",\"string\"],\"default\":null},{\"name\":\"mobileLink\",\"type\":[\"null\",\"string\"],\"default\":null},{\"name\":\"price\",\"type\":\"AmountWithCurrency\"},{\"name\":\"publisherGroupId\",\"type\":[\"null\",\"long\"],\"default\":null},{\"name\":\"salePrice\",\"type\":[\"null\",\"AmountWithCurrency\"],\"default\":null},{\"name\":\"salePriceEffectiveEndDate\",\"type\":[\"null\",\"long\"],\"default\":null},{\"name\":\"salePriceEffectiveStartDate\",\"type\":[\"null\",\"long\"],\"default\":null},{\"name\":\"searchable\",\"type\":\"boolean\",\"default\":true},{\"name\":\"serviceableAreas\",\"type\":[\"null\",\"string\"],\"default\":null},{\"name\":\"shipping\",\"type\":[\"null\",\"Shipping\"],\"default\":null},{\"name\":\"targetCountry\",\"type\":[\"null\",\"string\"],\"default\":null},{\"name\":\"title\",\"type\":[\"null\",\"string\"],\"default\":null},{\"name\":\"currentAsOf\",\"type\":\"long\"},{\"name\":\"isDeleted\",\"type\":\"boolean\",\"default\":false},{\"name\":\"md5Sum\",\"type\":[\"null\",\"string\"],\"default\":null}]},{\"type\":\"record\",\"name\":\"Shopping\",\"fields\":[{\"name\":\"product\",\"type\":\"Product\"},{\"name\":\"availability\",\"type\":[\"null\",\"string\"],\"default\":null},{\"name\":\"availabilityDate\",\"type\":[\"null\",\"long\"],\"default\":null},{\"name\":\"expirationDate\",\"type\":[\"null\",\"long\"],\"default\":null},{\"name\":\"unitPricingMeasure\",\"type\":[\"null\",\"string\"],\"default\":null},{\"name\":\"unitPricingBaseMeasure\",\"type\":[\"null\",\"string\"],\"default\":null},{\"name\":\"installment\",\"type\":[\"null\",\"Installment\"],\"default\":null},{\"name\":\"itemGroupId\",\"type\":[\"null\",\"string\"],\"default\":null},{\"name\":\"loyaltyPoints\",\"type\":[\"null\",\"LoyaltyPoints\"],\"default\":null},{\"name\":\"googleProductCategory\",\"type\":[\"null\",\"GoogleProductCategory\"],\"default\":null},{\"name\":\"productType\",\"type\":[\"null\",{\"type\":\"array\",\"items\":\"string\"}],\"default\":null},{\"name\":\"gtin\",\"type\":[\"null\",\"string\"],\"default\":null},{\"name\":\"mpn\",\"type\":[\"null\",\"string\"],\"default\":null},{\"name\":\"identifierExists\",\"type\":[\"null\",\"boolean\"],\"default\":null},{\"name\":\"condition\",\"type\":[\"null\",\"string\"],\"default\":null},{\"name\":\"adult\",\"type\":[\"null\",\"boolean\"],\"default\":null},{\"name\":\"multipack\",\"type\":[\"null\",\"int\"],\"default\":null},{\"name\":\"isBundle\",\"type\":[\"null\",\"boolean\"],\"default\":null},{\"name\":\"energyEfficiencyClass\",\"type\":[\"null\",\"string\"],\"default\":null},{\"name\":\"energyEfficiencyClassMin\",\"type\":[\"null\",\"string\"],\"default\":null},{\"name\":\"energyEfficiencyClassMax\",\"type\":[\"null\",\"string\"],\"default\":null},{\"name\":\"ageGroup\",\"type\":[\"null\",\"string\"],\"default\":null},{\"name\":\"color\",\"type\":[\"null\",\"string\"],\"default\":null},{\"name\":\"gender\",\"type\":[\"null\",\"string\"],\"default\":null},{\"name\":\"material\",\"type\":[\"null\",\"string\"],\"default\":null},{\"name\":\"minimumHandlingTime\",\"type\":[\"null\",\"string\"],\"default\":null},{\"name\":\"maximumHandlingTime\",\"type\":[\"null\",\"string\"],\"default\":null},{\"name\":\"pattern\",\"type\":[\"null\",\"string\"],\"default\":null},{\"name\":\"size\",\"type\":[\"null\",\"string\"],\"default\":null},{\"name\":\"sizeType\",\"type\":[\"null\",\"string\"],\"default\":null},{\"name\":\"sizeSystem\",\"type\":[\"null\",\"string\"],\"default\":null},{\"name\":\"tax\",\"type\":[\"null\",\"Tax\"],\"default\":null}]},{\"type\":\"record\",\"name\":\"ShoppingEvent\",\"fields\":[{\"name\":\"eventTime\",\"type\":\"long\"},{\"name\":\"decodeType\",\"type\":\"string\",\"default\":\"SHOPPING\"},{\"name\":\"eventType\",\"type\":\"string\"},{\"name\":\"advertiserId\",\"type\":\"string\"},{\"name\":\"catalogId\",\"type\":\"string\"},{\"name\":\"productId\",\"type\":\"string\"},{\"name\":\"product\",\"type\":[\"null\",\"Shopping\"]}]}],\"messages\":{}}");

  @org.apache.avro.specific.AvroGenerated
  public interface Callback extends AdvertisablesProtocol {
    public static final org.apache.avro.Protocol PROTOCOL = com.cj.prototype.avroGenerated.AdvertisablesProtocol.PROTOCOL;
  }
}
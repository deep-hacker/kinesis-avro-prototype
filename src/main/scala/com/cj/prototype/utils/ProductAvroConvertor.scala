package com.cj.prototype.utils

import com.cj.prototype.avroGenerated.{AmountWithCurrency, Product, Shopping, ShoppingEvent}
import com.cj.prototype.model.KinesisEvent.{DELETE, EventType}
import com.cj.prototype.model.{CJProduct, ProductCatalog}
import org.apache.avro.specific.SpecificRecordBase

import scala.util.Try

object ProductAvroConvertor {
  case class ProductAvroConverterException(msg: String) extends Exception(msg)

  private def cjProductToShoppingAvro(cjProduct: CJProduct, catalog: ProductCatalog, currentAsOf: Long): Shopping = {
    val product = cjProductToProductAvro(cjProduct, catalog, currentAsOf)

    Shopping.newBuilder()
      .setProduct(product)
      .build()
  }

  def cjProductToProductAvro(cjProduct: CJProduct, catalog: ProductCatalog, currentAsOf: Long) :  Product = {

    val productBuilder = Product.newBuilder()
      .setAdId(cjProduct.adId.toString)
      .setAdvertiserId(cjProduct.advertiserId.toString)
      .setAdvertiserName(cjProduct.advertiserName)
      .setCatalogId(cjProduct.catalogId.toString)
      .setDescription(cjProduct.description)
      .setId(cjProduct.id)
      .setLastUpdated(cjProduct.lastUpdated)
      .setPrice(new AmountWithCurrency(cjProduct.price.price.toString,cjProduct.price.currency))
      .setSearchable(if (Option(catalog.isSearchable).isDefined) catalog.isSearchable else false)
      .setTitle(cjProduct.name)
      .setCurrentAsOf(currentAsOf)
      .build()

    productBuilder
  }

  def cjProductToAdvertisablesEvent(product: CJProduct, catalog: ProductCatalog, eventType: EventType, eventTime: Long, sku: String): Try[SpecificRecordBase] = Try{
    (catalog.feedType, eventType) match {
      case ("GOOGLE", DELETE) => {
        ShoppingEvent.newBuilder()
          .setEventType(eventType.key)
          .setEventTime(eventTime)
          .setAdvertiserId(catalog.advertiserId.toString)
          .setCatalogId(catalog.id.toString)
          .setProductId(sku)
          .setProduct(null)
          .build()
      }

      case ("GOOGLE", _) => {
        val advertisable = cjProductToShoppingAvro(product, catalog, eventTime)
        ShoppingEvent.newBuilder()
          .setProduct(advertisable)
          .setEventType(eventType.key)
          .setEventTime(eventTime)
          .setAdvertiserId(catalog.advertiserId.toString)
          .setCatalogId(catalog.id.toString)
          .setProductId(product.id)
          .build()
      }

      case _ => throw ProductAvroConverterException(s"Invalid feedType ${catalog.feedType}. Cannot convert catalog ${catalog.id}.")
    }
  }
}

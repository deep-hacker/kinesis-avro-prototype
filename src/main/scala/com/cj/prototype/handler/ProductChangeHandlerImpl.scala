package com.cj.prototype.handler
import com.cj.prototype.kinesis.KinesisWriter
import com.cj.prototype.model.KinesisEvent.EventType
import com.cj.prototype.model.{CJProduct, KinesisEvent, ProductCatalog, eventToBytes}
import com.cj.prototype.utils.ProductAvroConvertor
import org.apache.avro.specific.SpecificRecordBase

import scala.util.{Failure, Success, Try}

class ProductChangeHandlerImpl(catalog: ProductCatalog,kinesisClient:KinesisWriter) extends ProductChangeHandler {
  override def newProduct(product: CJProduct): Unit = publishProduct(product,catalog,KinesisEvent.CREATE)

  override def updatedProduct(product: CJProduct): Unit = publishProduct(product,catalog,KinesisEvent.UPDATE)

  override def existingProduct(product: CJProduct): Unit = ???

  override def notAvailableProduct(product: CJProduct): Unit = publishProduct(product,catalog,KinesisEvent.DELETE)

  override def rejectedProduct(skuOption: Option[String]): Unit = ???

  def attemptKinesisSend(kinesisClient: KinesisWriter, event: SpecificRecordBase, catalogId: Long, sku: String, eventType: EventType): Unit = {
    eventToBytes(event).foreach(tuple => {
      val (label, data) = tuple
      Try (kinesisClient.sendData(data,label)) match {
        case Success(_) => //all good here
        case Failure(e) => println(s"Failed to send $eventType event (catalog $catalogId, sku $sku) to kinesis due to ${e.getMessage}")
      }
    })
  }
  def publishProduct(product: CJProduct, catalog: ProductCatalog, eventType: EventType): Unit = {
    if (kinesisClient.kinesisEnabled) {
      Try {
        val now = System.currentTimeMillis()
        ProductAvroConvertor.cjProductToAdvertisablesEvent(product, catalog, eventType, now, product.id) match {
          case Success(advertisablesEvent: SpecificRecordBase) => {
            attemptKinesisSend(kinesisClient, advertisablesEvent, catalog.id, product.id, eventType)
          }
          case Failure(e) => println(s"Failed to convert product due to ${e.getMessage}: not sending to kinesis.")
        }
      }
    }
  }
}

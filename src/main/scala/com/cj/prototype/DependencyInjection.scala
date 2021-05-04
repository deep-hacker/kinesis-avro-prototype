package com.cj.prototype

import com.cj.prototype.fakeGenerator.FakeEventGenerator
import com.cj.prototype.handler.{ProductChangeHandler, ProductChangeHandlerImpl}
import com.cj.prototype.kinesis.{KinesisWriter, KinesisWriterImpl}
import com.cj.prototype.model.ProductCatalog
import com.cj.prototype.producer.ProducerFactory


class DependencyInjection() {
   val producerFactory = new ProducerFactory
   val streamName = "StockTradeStream"
   val kinesisProducerClient:KinesisWriter = new KinesisWriterImpl(streamName,producerFactory.createKinesisProducer())
   val catalog:ProductCatalog = ProductCatalog(534,11345,"GOOGLE",965,true,true,"USA","en",System.currentTimeMillis(),System.currentTimeMillis(),1,"USD","USA")
   val productChangeHandler:ProductChangeHandler = new ProductChangeHandlerImpl(catalog,kinesisProducerClient)
   val fakeGenerator = new FakeEventGenerator(productChangeHandler)
}

package com.cj.prototype

import com.cj.prototype.producer.ProducerFactory
import com.cj.prototype.producerclient.ProducerClient

import java.nio.ByteBuffer

class DependencyInjection() {
   val producerFactory = new ProducerFactory
   val streamName = "StockTradeStream"
   val producerClient = new ProducerClient(producerFactory.createKinesisProducer,streamName)
}

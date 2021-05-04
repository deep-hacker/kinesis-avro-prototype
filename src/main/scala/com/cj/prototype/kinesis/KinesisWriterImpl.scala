package com.cj.prototype.kinesis

import com.amazonaws.services.kinesis.producer.{KinesisProducer, UserRecordResult}
import com.yammer.metrics.Metrics
import com.yammer.metrics.core.Counter

import java.nio.ByteBuffer
import scala.concurrent.ExecutionContext.Implicits.global
import scala.concurrent.Future
import scala.util.{Failure, Success}

class KinesisWriterImpl(streamName:String,producer:KinesisProducer) extends   KinesisWriter {

  val successCounter: Counter = Metrics.newCounter(classOf[KinesisWriter], "successCount")
  val failureCounter: Counter = Metrics.newCounter(classOf[KinesisWriter], "failureCount")
  var backpressureMaxRecordCount : Int = 10000
  var backpressureWaitMilli : Int = 50


  override def successCount = successCounter.count()

  override def failureCount = failureCounter.count()

  override def incrementSuccessCount = successCounter.inc()

  override def incrementFailureCount: Unit = failureCounter.inc()

  def getBackpressureMaxRecordCount(): Int = {
    backpressureMaxRecordCount
  }

  def setBackpressureMaxRecordCount(newSetting: Int): Unit = {
    println(s"Changing MaxRecordCount from ${backpressureMaxRecordCount} to ${newSetting}")
    backpressureMaxRecordCount = newSetting
  }

  def getBackpressureWaitMilli(): Int = {
    backpressureWaitMilli
  }

  def setBackpressureWaitMilli(newSetting: Int): Unit = {
    println(s"Changing backpressureWaitMilli from ${backpressureWaitMilli} to ${newSetting}")
    backpressureWaitMilli = newSetting
  }

  def sendData(data: ByteBuffer, label: String): Future[UserRecordResult] = {
    val futureResult: Future[UserRecordResult] = addUserRecord(streamName, data)
    futureResult.onComplete {
      case Success(value) => {
        if (value.isSuccessful) {
          incrementSuccessCount
          println(s"Sent successfully  with shardId: ${value.getShardId} and sequenceValue: ${value.getSequenceNumber}")
        }
        else {
          incrementFailureCount
          println(s"Can't send data for $label after ${value.getAttempts.size()} attempts")
        }
      }
      case Failure(exception) => {
        incrementFailureCount
        println(s"Error due to ${exception.getMessage}")
      }
    }
    futureResult
  }

  override def addUserRecord(streamName: String, data: ByteBuffer): Future[UserRecordResult] = {
    var outstandingRecordsCount = producer.getOutstandingRecordsCount
    var counter = 0
    while (outstandingRecordsCount > getBackpressureMaxRecordCount()) {
      if(every1Minute(counter, getBackpressureWaitMilli)) {
        println(s"BackpressureMaxRecordCount exceeded. getBackpressureMaxRecordCount: ${getBackpressureMaxRecordCount}, outstandingRecordsCount: ${outstandingRecordsCount}, getBackpressureWaitMilli: ${getBackpressureWaitMilli}, counter: ${counter}")
      }
      Thread.sleep(getBackpressureWaitMilli)
      outstandingRecordsCount = producer.getOutstandingRecordsCount
      counter = counter + 1
    }
    producer.addUserRecord(streamName, "product", data) }
}


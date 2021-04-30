package com.cj.prototype.kinesis

import com.amazonaws.services.kinesis.producer.{KinesisProducer, UserRecordResult}
import com.yammer.metrics.Metrics
import com.yammer.metrics.core.Counter

import java.nio.ByteBuffer
import scala.concurrent.ExecutionContext.Implicits.global
import scala.concurrent.Future
import scala.util.{Failure, Success}

class KinesisWriter(streamName:String,producer: KinesisProducer) {
  val successCounter : Counter = Metrics.newCounter(classOf[KinesisWriter], "successCount")
  val failureCounter:Counter = Metrics.newCounter(classOf[KinesisWriter], "failureCount")
  var kinesisEnabled = true

  def successCount = successCounter.count()
  def failureCount = failureCounter.count()
  def incrementSuccessCount = successCounter.inc()
  def incrementFailureCount = failureCounter.inc()

  def sendData(data: ByteBuffer,label:String): Future[UserRecordResult] = {
    val futureResult: Future[UserRecordResult] = producer.addUserRecord(streamName, "product", data)
    futureResult.onComplete{
      case Success(value) => {
        if(value.isSuccessful) {
          incrementSuccessCount
          println(s"Sent successfully  with shardId: ${value.getShardId} and sequenceValue: ${value.getSequenceNumber}")
        }
        else{
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

}

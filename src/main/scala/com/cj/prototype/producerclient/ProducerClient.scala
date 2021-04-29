package com.cj.prototype.producerclient

import com.amazonaws.services.kinesis.producer.{KinesisProducer, UserRecordResult}
import com.google.common.util.concurrent.{Futures, ListenableFuture}
import org.apache.http.concurrent.FutureCallback

import scala.concurrent.Future
import java.nio.ByteBuffer
import java.util.concurrent.Executor
import scala.concurrent.ExecutionContext.Implicits.global
import scala.util.{Failure, Success}

class ProducerClient(val producer:KinesisProducer,val streamName:String) {

  def sendData(data: ByteBuffer): Future[UserRecordResult] = {
    val futureResult: Future[UserRecordResult] = producer.addUserRecord(streamName, "product", data)
    futureResult.onComplete{
      case Success(value) => {
        if(value.isSuccessful) {
          println(s"Sent successfully  with shardId: ${value.getShardId} and sequenceValue: ${value.getSequenceNumber}")
        }
        else{
          println(s"Can't send data after ${value.getAttempts.size()} attempts")
        }
      }
      case Failure(exception) => {
        println(s"Error due to ${exception.getMessage}")
      }
    }
    futureResult
  }
}

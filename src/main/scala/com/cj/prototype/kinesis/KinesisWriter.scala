package com.cj.prototype.kinesis

import com.amazonaws.services.kinesis.producer.UserRecordResult

import java.nio.ByteBuffer
import scala.concurrent.Future

trait KinesisWriter {
  def successCount:Long
  def failureCount:Long
  def incrementSuccessCount
  def incrementFailureCount
  def sendData(data: ByteBuffer, label: String): Future[UserRecordResult]
  def addUserRecord(streamName:String,data:ByteBuffer):Future[UserRecordResult]
}

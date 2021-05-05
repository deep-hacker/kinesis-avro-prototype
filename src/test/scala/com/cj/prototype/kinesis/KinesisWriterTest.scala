package com.cj.prototype.kinesis

import com.amazonaws.services.kinesis.producer.UserRecordResult
import com.cj.prototype.avroGenerated.{Product, Shopping, ShoppingEvent}
import com.cj.prototype.model.{KinesisEvent, eventToBytes}
import com.cj.prototype.avroGenerated.AmountWithCurrency
import com.google.common.util.concurrent.MoreExecutors
import org.joda.time.DateTime
import org.scalatest.funsuite.AnyFunSuite
import org.scalatest.matchers.should.Matchers
import org.scalatest.time.SpanSugar.convertIntToGrainOfTime

import java.nio.ByteBuffer
import java.util.concurrent.Executors.newFixedThreadPool
import java.util.concurrent.{Callable, ExecutorService}
import java.util.concurrent.atomic.AtomicLong
import scala.concurrent.ExecutionContext.Implicits.global
import scala.concurrent.{Await, Future}
import scala.language.postfixOps
import scala.util.{Failure, Success}

class KinesisWriterTest extends AnyFunSuite with Matchers{

  class KinesisWriterTestConfig(listener: UserRecordResult => Callable[UserRecordResult], userRecordResult: UserRecordResult, execService: ExecutorService) extends KinesisWriter  {
    val service = MoreExecutors.listeningDecorator(execService)
    val listenableFuture = service.submit(listener(userRecordResult))
    val testSuccessCount = new AtomicLong(0)
    val testFailureCount = new AtomicLong(0)

    override def incrementSuccessCount:Unit = testSuccessCount.incrementAndGet()
    override def incrementFailureCount:Unit = testFailureCount.incrementAndGet()
    override def successCount = testSuccessCount.get()
    override def failureCount = testFailureCount.get()

    override def sendData(data: ByteBuffer, label: String): Future[UserRecordResult] = {
      val futureResult: Future[UserRecordResult] = addUserRecord("streamName", data)
      futureResult.onComplete {
        case Success(value) => {
          if (value.isSuccessful) {
            incrementSuccessCount
          }
          else {
            incrementFailureCount
          }
        }
        case Failure(exception) => {
          incrementFailureCount
        }
      }
      futureResult
    }

    override def addUserRecord(streamName: String, data: ByteBuffer): Future[UserRecordResult] = listenableFuture
  }

  val executorService = newFixedThreadPool(1)

  test("should increment successCount when kinesis send is successful - shopping") {
    //given
    def listener(returnVal:UserRecordResult) = {
      new Callable[UserRecordResult] {
        override def call(): UserRecordResult = returnVal
      }
    }
    val userRecordResult = new UserRecordResult(new java.util.ArrayList(),"sequence1","shardId1",true)
    val kinesisWriter = new KinesisWriterTestConfig(listener, userRecordResult, executorService)
    val (label, data) = eventToBytes(theShoppingEvent).get
    //when
    val sendResult: UserRecordResult = Await.result(kinesisWriter.sendData(data, label), 1 seconds)
    //then
    sendResult should be (userRecordResult)
    kinesisWriter.successCount should be (1)
  }

  test("should increment failureCount when kinesis send is failed - shopping") {
    //given
    def listener(returnVal:UserRecordResult) = {
      new Callable[UserRecordResult] {
        override def call(): UserRecordResult = returnVal
      }
    }
    val userRecordResult1 = new UserRecordResult(new java.util.ArrayList(),"sequence1","shardId1",false)
    val kinesisWriter = new KinesisWriterTestConfig(listener, userRecordResult1, executorService)
    val (label, data) = eventToBytes(theShoppingEvent).get
    //when
    val sendResult: UserRecordResult = Await.result(kinesisWriter.sendData(data, label), 1 seconds)
    //then
    sendResult should be (userRecordResult1)
    kinesisWriter.failureCount should be (1)
    kinesisWriter.successCount should be (0)
  }

  def now = System.currentTimeMillis()

  def lastUpdated = new DateTime()
  def price = AmountWithCurrency.newBuilder()
    .setAmount("20.00")
    .setCurrency("USD")
    .build()
  def theProduct = Product.newBuilder()
    .setAdId("654654")
    .setAdvertiserId("987654")
    .setAdvertiserName("advertiserName")
    .setCatalogId("123456")
    .setDescription("description")
    .setId("id")
    .setLastUpdated(lastUpdated.getMillis)
    .setPrice(price)
    .setCurrentAsOf(now)
    .build()
  def theShopping = Shopping.newBuilder()
    .setProduct(theProduct).build()
  def theShoppingEvent = ShoppingEvent.newBuilder()
    .setProduct(theShopping)
    .setEventTime(1000L)
    .setEventType(KinesisEvent.CREATE.key)
    .setAdvertiserId(theProduct.getAdvertiserId)
    .setCatalogId(theProduct.getCatalogId)
    .setProductId(theProduct.getId)
    .build()

}

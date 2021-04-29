package com.cj.prototype.producer
import com.amazonaws.auth.{AWSStaticCredentialsProvider, BasicSessionCredentials}
import com.amazonaws.services.kinesis.producer.{KinesisProducer, KinesisProducerConfiguration}
class ProducerFactory {
  val awsAccessKeyId:String = System.getenv("AWS_ACCESS_KEY_ID")
  val awsSecretAccessKey:String = System.getenv("AWS_SECRET_ACCESS_KEY")
  val awsSessionToken:String = System.getenv("AWS_SESSION_TOKEN")

  def createKinesisProducer(): KinesisProducer ={
    val config = new KinesisProducerConfiguration()
      .setRegion("us-east-1")
      .setCredentialsProvider(new AWSStaticCredentialsProvider(new BasicSessionCredentials(awsAccessKeyId,awsSecretAccessKey,awsSessionToken)))
      .setRecordMaxBufferedTime(15000)
      .setRequestTimeout(6000)
    new KinesisProducer(config)
  }
}

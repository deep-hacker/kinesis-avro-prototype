package com.cj.prototype.model
import com.cj.prototype.avroGenerated.{Product}

import java.nio.ByteBuffer
import scala.util.Try
case class CJProduct(adId:Long,
                     advertiserId:Long,
                     advertiserName:String,
                     catalogId:Long,
                     description:String,
                     id:String,
                     name:String,
                     lastUpdated:Long,
                     price:AmountWithCurrency,
                     searchable:Boolean,
                     eventTime:Long,
                     isDeleted:Boolean)


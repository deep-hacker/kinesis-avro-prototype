package com.cj.prototype.model
import com.cj.prototype.avro.product
import java.nio.ByteBuffer
import scala.util.Try
final case class CJProduct(id:Int,name:String,price:Double,quantity:Int) {
    def productToEvent:Try[ByteBuffer] = {
      Try{
        val productEvent = product.newBuilder()
          .setId(id)
          .setName(name)
          .setPrice(price)
          .setQuantity(quantity)
          .build()
        val serializer = mkAvroSerializer[product]()
        ByteBuffer.wrap(serializer(productEvent))
      }
    }
}

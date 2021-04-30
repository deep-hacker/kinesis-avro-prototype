package com.cj.prototype
import com.cj.prototype.avroGenerated.ShoppingEvent
import org.apache.avro.io.{BinaryEncoder, DatumWriter, EncoderFactory}
import org.apache.avro.specific.{SpecificDatumWriter, SpecificRecord, SpecificRecordBase}

import java.io.ByteArrayOutputStream
import java.nio.ByteBuffer
package object model {
    def mkAvroSerializer[T <: SpecificRecord](): T => Array[Byte] = {
      val output = new ByteArrayOutputStream()
      val writer: DatumWriter[T] = new SpecificDatumWriter[T]()
      var encoder: BinaryEncoder = EncoderFactory.get().binaryEncoder(output, null)
      record => {
        output.reset()
        encoder = EncoderFactory.get().binaryEncoder(output, encoder)
        writer.setSchema(record.getSchema)
        writer.write(record, encoder)
        encoder.flush()
        output.close()
        output.toByteArray
      }
    }

  def eventToBytes(base: SpecificRecordBase): Option[(String, ByteBuffer)] = {
    base match {
      case s: ShoppingEvent => {
        val kinesisLabel = s"shopping EventType:${s.getEventType}, AdvertiserId:${s.getAdvertiserId}, CatalogId:${s.getCatalogId}, ProductId:${s.getProductId}"
        val serializer = mkAvroSerializer[ShoppingEvent]()
        val data = ByteBuffer.wrap(serializer(s))
        Some(kinesisLabel, data)
      }
      case _ => None
    }
  }
}

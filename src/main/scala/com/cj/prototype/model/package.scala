package com.cj.prototype
import org.apache.avro.io.{BinaryEncoder, DatumWriter, EncoderFactory}
import org.apache.avro.specific.{SpecificDatumWriter, SpecificRecord}

import java.io.ByteArrayOutputStream
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
}

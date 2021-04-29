package com.cj.prototype

import com.cj.prototype.model.CJProduct
import org.apache.log4j.BasicConfigurator

import scala.util.{Failure, Success}

object EntryPoint extends App {
  BasicConfigurator.configure()
    val cjProduct = CJProduct(1,"T-shirts",250,2)
    val data = cjProduct.productToEvent match {
      case Success(value) => {
        value
      }
      case Failure(e) => {
        throw e.getCause
      }
    }
    val dependencyInjection = new DependencyInjection
     while(true) {
       dependencyInjection.producerClient.sendData(data)
       Thread.sleep(5000)
     }
}

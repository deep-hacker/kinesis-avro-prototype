package com.cj.prototype.fakeGenerator

import com.cj.prototype.handler.ProductChangeHandler
import com.cj.prototype.model.{AmountWithCurrency, CJProduct, ProductCatalog}

import scala.collection.mutable.ArrayBuffer
import scala.util.Random

class FakeEventGenerator(productChangeHandler: ProductChangeHandler) {
  val random = new Random()
  val product:CJProduct = new CJProduct(12345,11345,"Demo",534,"dummmy product","Demo12345","Dummy",System.currentTimeMillis(), AmountWithCurrency(54.00,"USD"),true,System.currentTimeMillis(),false)
  var productList = ArrayBuffer[String]()
  def createProduct() = {
    populateProductList()
    for(_ <- 1 to 500){
      val product = new CJProduct(12345,11345,"CJ Demo",534,s"dummy product${random.nextInt(500)}",s"Dummy ${random.nextInt(5000)}",productList(random.nextInt(productList.size)),System.currentTimeMillis(),AmountWithCurrency(random.nextDouble*600.00,"USD"),true,System.currentTimeMillis(),false)
      productChangeHandler.newProduct(product)
    }
  }

  def updateProduct() = {
    productChangeHandler.updatedProduct(product)
  }

  def removeProduct() = {
    productChangeHandler.notAvailableProduct(product)
  }

  private def populateProductList(): Unit = {
    productList.addOne("shirt")
    productList.addOne("t-shirt")
    productList.addOne("shorts")
    productList.addOne("tie")
    productList.addOne("shoes")
    productList.addOne("jeans);")
    productList.addOne("belt")
  }

}

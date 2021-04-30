package com.cj.prototype.handler

import com.cj.prototype.model.CJProduct

  trait ProductChangeHandler {
    def newProduct(product: CJProduct)

    def updatedProduct(product: CJProduct)

    def existingProduct(product: CJProduct)

    def notAvailableProduct(product: CJProduct)

    def rejectedProduct(skuOption: Option[String])

}

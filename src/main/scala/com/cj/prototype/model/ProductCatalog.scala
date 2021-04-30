package com.cj.prototype.model


case class ProductCatalog(id:Long,
                          advertiserId:Long,
                          feedType:String,
                          groupId:Long,
                          isSearchable: Boolean,
                          isTestMode: Boolean,
                          targetCountry: String,
                          language: String,
                          lastUpdated: Long,
                          lastConsistencyCheck: Long,
                          productCount: Long,
                          currency: String,
                          advertiserCountry: String)


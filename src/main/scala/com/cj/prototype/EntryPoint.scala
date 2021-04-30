package com.cj.prototype

import org.apache.log4j.BasicConfigurator

object EntryPoint extends App {
  BasicConfigurator.configure()
    val dependencyInjection = new DependencyInjection
     while(true) {
       dependencyInjection.fakeGenerator.createProduct()
       Thread.sleep(5000)
       dependencyInjection.fakeGenerator.updateProduct()
       Thread.sleep(5000)
       dependencyInjection.fakeGenerator.removeProduct()
       Thread.sleep(5000)
     }
}

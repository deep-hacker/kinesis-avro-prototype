package com.cj.prototype

import com.google.common.util.concurrent.ListenableFuture

import scala.concurrent.{ExecutionContext, Future, Promise}
import scala.util.Try

package object kinesis {
  private[kinesis] implicit def listenableToScalaFuture[A](listenable: ListenableFuture[A]): Future[A] = {
    val promise = Promise[A]
    val callback = new Runnable {
      override def run(): Unit = promise.tryComplete(Try(listenable.get()))
    }
    listenable.addListener(callback, ExecutionContext.global)
    promise.future
  }

  def every1Minute(counter: Int, waitMilli:Int) : Boolean = {
    (counter * waitMilli) % (60000) < waitMilli
  }
}

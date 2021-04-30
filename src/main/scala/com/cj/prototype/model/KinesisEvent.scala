package com.cj.prototype.model

 object KinesisEvent {
  sealed abstract class EventType (val key: String)

  case object CREATE extends EventType ("CREATE")
  case object DELETE extends EventType ("DELETE")
  case object UPDATE extends EventType ("UPDATE")

  def fromKey(key: String): EventType = {
    key match {
      case CREATE.key => CREATE
      case DELETE.key => DELETE
      case UPDATE.key => UPDATE
    }
  }
}

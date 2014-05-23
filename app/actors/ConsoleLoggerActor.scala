package actors

import akka.actor.{Props, Actor}
import play.api.libs.concurrent.Akka

class ConsoleLoggerActor extends Actor {
  override def receive: Receive = {
    case elem => println(s"received from $sender message \"$elem\"")
  }
}


object ConsoleLoggerActor {

  import conf.Configuration._

  val actor = Akka.system.actorOf(Props[ConsoleLoggerActor], "console_actor")
}

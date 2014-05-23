package actors

import akka.actor.{Props, Actor}
import play.api.libs.concurrent.Akka

class GreetingActor extends Actor {

  override def receive: Receive = {
    case name: String => sender ! s"Hello $name"
  }
}

object GreetingActor {

  import conf.Configuration._

  val actor = Akka.system.actorOf(Props[GreetingActor], "myactor")
}

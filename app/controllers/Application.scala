package controllers

import play.api._
import play.api.mvc._
import scala.concurrent.Future
import akka.pattern.ask
import actors.GreetingActor
import Configuration._

object Application extends Controller {

  def greet(name: String) = Action.async {
    import conf.Configuration._
    import scala.concurrent.ExecutionContext.Implicits.global

    val ala: Future[Any] = GreetingActor.actor ? name
    Future(Ok(""))
  }

}
package controllers

import play.api._
import play.api.mvc._
import scala.concurrent.Future
import akka.pattern.ask
import actors.{ConsoleLoggerActor, GreetingActor}
import scala.concurrent.ExecutionContext.Implicits.global
import conf.Configuration._


object Application extends Controller {

  def greet(name: String) = {
    ConsoleLoggerActor.actor ! name
    Action.async {
      val result: Future[Any] = GreetingActor.actor ? name
      result.map(response => Ok(response.asInstanceOf[String]))
    }
  }

}
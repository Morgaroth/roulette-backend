package conf

import akka.util.Timeout
import scala.concurrent.duration._

object Configuration {
  implicit val implicitPlayApplication = play.api.Play.current
  implicit val timeout = Timeout(5 seconds)
}

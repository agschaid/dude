package the.dude

import scala.concurrent.duration._
import akka.actor._
import akka.http.scaladsl.Http
import akka.http.scaladsl.server.Route
import akka.http.scaladsl.model.HttpMethods._
import akka.http.scaladsl.model._
import akka.stream.ActorMaterializer
import akka.util.Timeout

import com.typesafe.config.ConfigFactory

object Main extends App {

  val config = ConfigFactory.load()
  val host = config.getString("http.host")
  val port = config.getInt("http.port")

  println(s"$host : $port")
  implicit val system = ActorSystem("donny-and-walter")
  implicit val materializer = ActorMaterializer()
  implicit val executionContext = system.dispatcher
  implicit val timeout = Timeout(10 seconds)

  val requestHandler: HttpRequest => HttpResponse = {
    // case HttpRequest(GET, Uri.Path("/"), _, _, _) =>
    //   HttpResponse(entity = HttpEntity(MediaTypes.`text/html`,
    //     "<html><body>Hello world!</body></html>"))

      case HttpRequest(GET, Uri.Path("/ping"), _, _, _) =>
        HttpResponse(entity = "PONG!")

      case HttpRequest(GET, Uri.Path("/crash"), _, _, _) =>
        sys.error("BOOM!")

      case _: HttpRequest =>
        HttpResponse(404, entity = "Unknown resource!")
  }
    

}


package the.dude

import scala.concurrent.duration._
import akka.actor._
import akka.http.scaladsl.Http
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

}


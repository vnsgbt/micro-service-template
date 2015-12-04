package mrcsvc

/**
  * Created by steve on 12/3/15.
  */

import mrcsvc.configs.BaseConfig

import scala.concurrent.ExecutionContext
import akka.actor.ActorSystem
import akka.event.{ Logging, LoggingAdapter }
import akka.http.scaladsl.Http
import akka.stream.ActorMaterializer

import mrcsvc.routes.BaseRoute

object Main extends App with BaseRoute with BaseConfig {
  private implicit val system = ActorSystem()

  protected implicit val executor: ExecutionContext = system.dispatcher
  protected val log: LoggingAdapter = Logging(system, getClass)
  protected implicit val materializer: ActorMaterializer = ActorMaterializer()

  Http().bindAndHandle(routes, httpInterface, httpPort)
}

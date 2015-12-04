package mrcsvc.routes

/**
  * Created by steve on 12/4/15.
  */

import akka.http.scaladsl.server.Directives._

trait BaseRoute {
  val routes =
    pathPrefix("mrcsvc") {
      get {
        complete("Hello world!")
      }
    }
}

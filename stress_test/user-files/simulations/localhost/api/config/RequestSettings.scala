package simulations.localhost.api.config

import io.gatling.core.Predef._
import io.gatling.http.Predef._
import scala.concurrent.duration._

object RequestSettings {
  object api {
    val PROTOCOL = "http"
    val DOMAIN   = "localhost"
    val PORT     =  8081
    val BASE_URL = PROTOCOL + "://" + DOMAIN + ":" + PORT
  }

  val httpConf = http.baseURL(api.BASE_URL)
}

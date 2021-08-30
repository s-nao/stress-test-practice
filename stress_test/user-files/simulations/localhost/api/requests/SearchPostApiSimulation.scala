package simulations.localhost.api.requests

import io.gatling.core.Predef._
import io.gatling.http.Predef._
import io.gatling.core.feeder.RecordSeqFeederBuilder
import scala.concurrent.duration._

import simulations.localhost.api.config.RequestSettings

class SearchPostApiSimulation extends Simulation {
  val user_date_feed: RecordSeqFeederBuilder[String] = csv("search.csv").circular

  val senario = scenario("[post]検索APIテスト")
    .exec(http("user post api")
      .post("/api/search")
      .body(StringBody("""{"words":"$SearchWords"}"""))
      .check(
        status.is(200)
      )
    )

  setUp(
    senario.inject(
      rampUsersPerSec(1) to 5 during (10 second),
      constantUsersPerSec(5) during(10 seconds)
    )
  ).protocols(RequestSettings.httpConf)
}

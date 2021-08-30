package simulations.localhost.api.requests

import io.gatling.core.Predef._
import io.gatling.http.Predef._
import io.gatling.core.feeder.RecordSeqFeederBuilder
import scala.concurrent.duration._

import simulations.localhost.api.config.RequestSettings

class ApiMixedSimulation extends Simulation {
  val user_date_feed: RecordSeqFeederBuilder[String] = csv("search.csv").circular

  val senarioSearch = scenario("[post]検索APIテスト")
    .exec(http("user post api")
      .post("/api/search")
      .body(StringBody("""{"words":"$SearchWords"}"""))
      .check(
        status.is(200)
      )
    )

  val senarioUsers = scenario("[GET]ユーザーAPIテスト")
    .exec(http("user get api")
      .get("/api/users")
      .check(status.is(200)))

  setUp(
    senarioSearch.inject(
      rampUsersPerSec(1) to 10 during (10 second),
      constantUsersPerSec(10) during(10 seconds)
    ),
    senarioUsers.inject(
      rampUsersPerSec(1) to 5 during (10 second),
      constantUsersPerSec(5) during(10 seconds)
    )
  ).protocols(RequestSettings.httpConf)
}

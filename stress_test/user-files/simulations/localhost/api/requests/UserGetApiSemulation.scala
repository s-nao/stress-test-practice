package simulations.localhost.api.requests

import io.gatling.core.Predef._
import io.gatling.http.Predef._
import scala.concurrent.duration._

import simulations.localhost.api.config.RequestSettings

class UserGetApiSemulation extends Simulation {

  val senario = scenario("[GET]ユーザーAPIテスト")
                      .exec(http("user get api")
                      .get("/api/users")
                      .check(status.is(200)))

  setUp(
    senario.inject(
      rampUsersPerSec(1) to 5 during (10 second),
      constantUsersPerSec(5) during(10 seconds)
    )
  ).protocols(RequestSettings.httpConf)
}

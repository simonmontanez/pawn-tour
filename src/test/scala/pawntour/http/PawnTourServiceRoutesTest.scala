package pawntour.http

import akka.http.scaladsl.server.Route
import akka.http.scaladsl.testkit.ScalatestRouteTest
import org.scalatest.{Matchers, WordSpec}
import pawntour.domain.Coordinate
import spray.json.RootJsonFormat
import spray.json.DefaultJsonProtocol._
import akka.http.scaladsl.marshallers.sprayjson.SprayJsonSupport._
import akka.http.scaladsl.model.StatusCodes._

class PawnTourServiceRoutesTest
    extends WordSpec
    with Matchers
    with ScalatestRouteTest
    with PawnTourServiceRoutes {

  override implicit val itemFormat: RootJsonFormat[Coordinate] = jsonFormat2(
    Coordinate)

  "PawnTourService" should {

    "given an initial position return one path to visit all tiles" in {
      Get("/pawn-tour?raw=0&col=1") ~> Route.seal(pawnTour) ~> check {
        status shouldEqual OK
        responseAs[List[Coordinate]].size shouldEqual 100
      }
    }

    "return error if the initial position is not valid" in {
      Get("/pawn-tour?raw=10&col=1") ~> Route.seal(pawnTour) ~> check {
        status shouldEqual InternalServerError
      }
    }
  }

}

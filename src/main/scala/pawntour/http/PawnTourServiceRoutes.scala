package pawntour.http

import akka.http.scaladsl.model.StatusCodes._
import akka.http.scaladsl.server.Directives.{complete, _}
import akka.http.scaladsl.server.Route
import com.typesafe.scalalogging.LazyLogging
import pawntour.domain.{Chequerboard, Coordinate, Pawn}
import spray.json.DefaultJsonProtocol._
import akka.http.scaladsl.marshallers.sprayjson.SprayJsonSupport._
import spray.json.RootJsonFormat

trait PawnTourServiceRoutes extends LazyLogging {

  implicit val itemFormat: RootJsonFormat[Coordinate] = jsonFormat2(Coordinate)

  def pawnTour: Route =
    path("pawn-tour") {
      get {
        parameter("raw".as[Int], "col".as[Int]) { (raw, col) =>
          val initialPosition = Coordinate(raw, col)
          logger.debug(
            s"Getting pawn from the initialPosition $initialPosition")

          val board = new Chequerboard
          board.initBoard()

          val pawn = Pawn(initialPosition, board)
          pawn
            .tour()
            .fold(
              e => {
                logger
                  .error("Error calculating a path from the initialPosition", e)
                complete(InternalServerError -> e.getMessage)
              },
              v => complete(v)
            )
        }
      }
    }

  val routes: Route = pawnTour
}

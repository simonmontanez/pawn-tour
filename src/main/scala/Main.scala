import akka.actor.ActorSystem
import akka.http.scaladsl.Http
import akka.stream.ActorMaterializer
import com.typesafe.scalalogging.LazyLogging
import pawntour.http.{DefaultConfig, PawnTourServiceRoutes}

import scala.concurrent.{Await, ExecutionContext}
import scala.util.{Failure, Success}
import scala.concurrent.duration._

object Main extends App with PawnTourServiceRoutes with LazyLogging {

  implicit val system: ActorSystem = ActorSystem("pawn-system")
  implicit val materializer: ActorMaterializer = ActorMaterializer()
  implicit val ec: ExecutionContext = system.dispatcher

  val bindingFuture: Unit = Http().bindAndHandle(
    routes,
    "localhost",
    DefaultConfig.httPort) onComplete {
    case Success(Http.ServerBinding(localAddress)) =>
      logger.info(s"Http service started. Listening $localAddress ")
    case Failure(exception) =>
      logger.error("Error binding http service", exception)
      system.terminate()
  }

  sys.addShutdownHook {
    logger.info("Shutting down")
    Await.ready(system.terminate(), 10.seconds)
    ()
  }

}

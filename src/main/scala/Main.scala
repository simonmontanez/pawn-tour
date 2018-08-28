import pawntour.domain.{Chequerboard, Coordinate, Pawn}

object Main extends App {

  val board = new Chequerboard
  board.initBoard()

  val pawn = Pawn(Coordinate(0, 0), board)

  val lastIndex = pawn.tour()

  println(s"lastIndex ${lastIndex.right.get.size} ")
  println(s"tour ${lastIndex.right.get.mkString} ")

}

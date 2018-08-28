package pawntour.domain

case class Pawn(initialPosition: Coordinate, board: Chequerboard) {

  private val movesOder = List(NW, W, SW, S, SE, E, NE, N)

  def tour(): List[Coordinate] = {
    move(initialPosition)
    findPath(initialPosition, movesOder, List(initialPosition))
  }

  def findPath(position: Coordinate,
               movesOder: List[PawnMove],
               visitedTour: List[Coordinate]): List[Coordinate] = {

    val next = nextMove(validNextMoves(position, movesOder))
    next match {
      case Some(c) =>
        move(c)
        findPath(c, movesOder, visitedTour :+ c)
      case _ if visitedTour.size < board.MAX_TILES =>
        board.initBoard()
        move(initialPosition)
        findPath(initialPosition,
                 movesOder.tail :+ movesOder.head,
                 List(initialPosition))
      case _ =>
        visitedTour
    }
  }

  def validNextMoves(
      position: Coordinate,
      movesOder: List[PawnMove] = movesOder): List[Coordinate] = {
    movesOder
      .map(_.position(position))
      .filter(board.isValidMove)
  }

  def move(position: Coordinate): Unit = {
    board.updateState(position)
  }

  def nextMove(moves: List[Coordinate]): Option[Coordinate] = {
    moves
      .map(f => (f, validNextMoves(f).size))
      .sortBy(_._2)
      .map(_._1)
      .headOption
  }
}

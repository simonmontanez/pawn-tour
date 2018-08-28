package pawntour.domain

sealed trait PawnMove {
  type Move = Coordinate => Coordinate
  val position: Move
}

object N extends PawnMove {
  val position: Move = (c: Coordinate) => c.copy(raw = c.raw - 3)
}

object NE extends PawnMove {
  val position: Move = (c: Coordinate) => Coordinate(c.raw - 2, c.col + 2)
}

object E extends PawnMove {
  val position: Move = (c: Coordinate) => c.copy(col = c.col + 3)
}

object SE extends PawnMove {
  val position: Move = (c: Coordinate) => Coordinate(c.raw + 2, c.col + 2)
}

object S extends PawnMove {
  val position: Move = (c: Coordinate) => c.copy(raw = c.raw + 3)
}

object SW extends PawnMove {
  val position: Move = (c: Coordinate) => Coordinate(c.raw + 2, c.col - 2)
}

object W extends PawnMove {
  val position: Move = (c: Coordinate) => c.copy(col = c.col - 3)
}

object NW extends PawnMove {
  val position: Move = (c: Coordinate) => Coordinate(c.raw - 2, c.col - 2)
}

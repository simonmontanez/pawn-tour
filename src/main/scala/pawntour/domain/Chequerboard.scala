package pawntour.domain

import scala.collection.mutable

class Chequerboard {

  val MAX_TILES = 100

  private val tiles = mutable.Map.empty[Int, List[Tile]]

  def updateState(position: Coordinate): Unit = {
    tiles(position.raw) = tiles(position.raw).map { t =>
      if (t.coordinate == position)
        t.copy(visited = true)
      else
        t
    }
  }

  def getTileByPosition(position: Coordinate): Option[Tile] = {
    tiles(position.raw).find(_.coordinate.col == position.col)
  }

  def isValidMove(position: Coordinate): Boolean = {
    !(position.raw < 0 || position.col < 0 ||
      position.raw > 9 || position.col > 9 ||
      tiles
        .get(position.raw)
        .exists(t =>
          t.exists(x => x.coordinate.col == position.col && x.visited)))
  }

  def initBoard(): Unit = {
    def initList(row: Int): List[Tile] = {
      List.tabulate(10)(col => Tile(Coordinate(row, col), false))
    }
    for (r <- 0 to 10) {
      tiles(r) = initList(r)
    }
  }

}

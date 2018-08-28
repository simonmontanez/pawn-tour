package pawntour.domain

import org.scalatest.{FlatSpec, Matchers, WordSpec}

class ChequerboardTest extends WordSpec with Matchers {
  val board = new Chequerboard

  "Chequerboard" should {
    "update state" in {
      val coordinate = Coordinate(0, 6)
      board.initBoard()

      board.updateState(coordinate)

      board.getTileByPosition(Coordinate(0, 6)) shouldBe Some(
        Tile(coordinate, true))
    }

    "init state with all the tiles no visited" in {
      board.initBoard()

      for (r <- 0 to 10) {
        for (c <- 0 to 10) {
          val coordinate = Coordinate(0, 6)
          board.getTileByPosition(coordinate) shouldBe Some(
            Tile(coordinate, false))
        }
      }
    }

    "validate move out the board" in {
      board.initBoard()
      board.isValidMove(Coordinate(-1, 6)) shouldBe false
      board.isValidMove(Coordinate(10, 6)) shouldBe false
      board.isValidMove(Coordinate(0, 10)) shouldBe false
      board.isValidMove(Coordinate(0, -1)) shouldBe false
    }

    "return false validating a visited tile" in {
      val coordinate = Coordinate(8, 5)

      board.initBoard()
      board.updateState(coordinate)

      board.isValidMove(Coordinate(8, 5)) shouldBe false
    }

  }
}

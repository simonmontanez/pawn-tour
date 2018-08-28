package pawntour.domain

import org.scalatest.{Matchers, WordSpec}

class PawnTest extends WordSpec with Matchers {
  val board = new Chequerboard

  "Pawn" should {
    "find one path with 100 steps starting in any initial position (10x10 board)" in {
      board.initBoard()

      for (r <- 0 to 9) {
        for (c <- 0 to 9) {
          val pawn = Pawn(Coordinate(r, c), board)
          pawn.tour().size shouldBe 100
        }
      }
    }

  }
}

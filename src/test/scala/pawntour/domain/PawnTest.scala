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
          val tour = pawn.tour()
          tour shouldBe 'right
          tour.right.get.size shouldBe 100
          board.initBoard()
        }
      }
    }

    "validate the initial position" in {
      board.initBoard()
      val initialPosition = Coordinate(0, -1)
      val pawn = Pawn(Coordinate(0, -1), board)
      val tour = pawn.tour()
      tour shouldBe 'left
      tour.left.get.getMessage shouldBe s"Initial position $initialPosition is not valid"

    }
  }
}

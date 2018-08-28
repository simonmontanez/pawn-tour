package pawntour.domain

import org.scalatest.{Matchers, WordSpec}

class PawnMoveTest extends WordSpec with Matchers {
  val board = new Chequerboard

  "PawnMove" should {
    "build an expected position" in {
      val coordinate = Coordinate(5, 0)
      N.position(coordinate) shouldBe Coordinate(2, 0)
      NE.position(coordinate) shouldBe Coordinate(3, 2)
      E.position(coordinate) shouldBe Coordinate(5, 3)
      SE.position(coordinate) shouldBe Coordinate(7, 2)
      S.position(coordinate) shouldBe Coordinate(8, 0)
      SW.position(coordinate) shouldBe Coordinate(7, -2)
      W.position(coordinate) shouldBe Coordinate(5, -3)
      NW.position(coordinate) shouldBe Coordinate(3, -2)

    }
  }

}

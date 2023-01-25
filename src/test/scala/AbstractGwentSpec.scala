package cl.uchile.dcc.gwent

import model.cards.Card

import org.scalatest.funsuite.AnyFunSuite
import org.scalatest.BeforeAndAfter
import org.scalatest.matchers.should
import org.scalatestplus.scalacheck.ScalaCheckPropertyChecks

class AbstractGwentSpec
    extends AnyFunSuite
    with ScalaCheckPropertyChecks
    with BeforeAndAfter
    with should.Matchers {
  protected var cards: List[Card] = _

  def initCards(): Unit = {
    cards = List(
      new Card("Sheldon Skaggs", 2, 4),
      new Card("Sigismund Dijkstra", 1, 1),
      new Card("Siege technician", 3, 0)
    )
  }
}

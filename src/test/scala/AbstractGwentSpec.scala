package cl.uchile.dcc.gwent

import model.cards.Card

import org.scalatest.funsuite.AnyFunSuite
import org.scalatest.BeforeAndAfter
import org.scalatest.matchers.should
import org.scalatestplus.scalacheck.ScalaCheckPropertyChecks

import scala.collection.mutable.ListBuffer

class AbstractGwentSpec
    extends AnyFunSuite
    with ScalaCheckPropertyChecks
    with BeforeAndAfter
    with should.Matchers {
  protected var cards: ListBuffer[Card] = _

  /**
   * Initializes the cards used in the tests.
   */
  def initCards(): Unit = {
    cards = ListBuffer.empty  // We crete an empty list of cards.
    for (i <- 1 to 25) {  // We add 25 cards to the list.
      cards += new Card("Card " + i, i % 3, 1)
    }
  }
}

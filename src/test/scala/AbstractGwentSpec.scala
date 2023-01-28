package cl.uchile.dcc.gwent

import model.{Battlefield, Player}
import model.cards.{Card, Deck}

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
  protected val player1Name: String = "Player 1"

  /** Initializes the cards used in the tests.
    */
  def createCards(): List[Card] = {
    cards = ListBuffer.empty // We crete an empty list of cards.
    for (i <- 1 to 25) { // We add 25 cards to the list.
      cards += new Card("Card " + i, i % 3, 1)
    }
    cards.toList
  }

  /** Initializes the player used in the tests.
    */
  def createPlayer(name: String, cards: List[Card]): Player =
    new Player(name, new Deck(cards), new Battlefield)
}

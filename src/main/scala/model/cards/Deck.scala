package cl.uchile.dcc.gwent
package model.cards

import model.Copyable

import scala.util.Random

/** A deck of cards.
  *
  * @constructor create a new deck with no cards.
  * @author <a href="https://www.github.com/r8vnhill">R8V</a>,
  *         ~Your name~
  * @since 1.0
  * @version 1.0
  */
class Deck(private val random: Random) extends Copyable {
  private var _cards: List[Card] = List()

  /** Creates a new deck with the given cards.
    *
    * @param cards The cards to add to the deck.
    */
  def this(cards: List[Card], random: Random = new Random()) = {
    this(random)
    _cards = cards
  }

  // region : Properties
  /** Returns the number of cards in the deck. */
  def size: Int = _cards.size

  /** Returns the cards in the deck. */
  def cards: List[Card] = _cards
  // endregion

  def copy(): Deck = {
    new Deck(_cards.map(_.copy()), random)
  }

  /**
   * Shuffles the deck.
   */
  def shuffle(): Unit = {
    _cards = random.shuffle(_cards)
  }

  // region : Operators
  /** Adds a card to the deck.
    *
    * @param card The card to add.
    */
  def +=(card: Card): Unit = {
    _cards = card :: _cards
  }

  /** Removes a card from the deck.
    *
    * @param card The card to remove.
    */
  def -=(card: Card): Unit = {
    _cards = _cards.filterNot(_ == card)
  }
  // endregion
}

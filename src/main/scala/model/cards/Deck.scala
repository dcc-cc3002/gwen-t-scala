package cl.uchile.dcc.gwent
package model.cards

/** A deck of cards.
  *
  * @constructor create a new deck with no cards.
  * @author <a href="https://www.github.com/r8vnhill">R8V</a>,
  *         ~Your name~
  * @since 1.0
  * @version 1.0
  */
class Deck {
  private var _cards: List[Card] = List()

  def this(cards: List[Card]) = {
    this()
    _cards = cards
  }

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

  /** Returns the cards in the deck. */
  def cards: List[Card] = _cards
}

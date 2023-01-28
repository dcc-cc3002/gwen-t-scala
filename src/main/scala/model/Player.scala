package cl.uchile.dcc.gwent
package model

import exceptions.{IllegalActionException, InvalidValueException}
import model.cards.{Card, Deck}

import java.util.Objects
import scala.collection.mutable

/** A class that holds the information of a player.
  *
  * @author <a href="https://github.com/r8vnhill">R8V</a>,
  *         ~Your name~
  * @since 1.0
  * @version 1.0
  */
class Player private(val name: String, val battlefield: Battlefield) {
  private var _gemCounter: Int = 2
  private var _deck: Deck = _
  private var _hand: List[Card] = List()

  /** Creates a new player with a name and a deck.
    *
    * @param name The name of the player.
    * @param deck The deck of the player.
    */
  def this(name: String, deck: Deck, battlefield: Battlefield) = {
    this(name, battlefield)
    if (deck.size != 25) { // Is it correct for the size restriction to be checked by the player?
      throw new InvalidValueException("The deck must start with 25 cards.")
    }
    _deck = deck
  }

  // region : Properties

  /** Returns a copy of the deck of the player. */
  def deck: Deck = _deck.copy()

  /** Returns the number of rounds won by the player. */
  def gemCounter: Int = _gemCounter

  /** Returns a copy of the hand of the player. */
  def hand: List[Card] = _hand.map(_.copy())

  /** Sets the number of rounds won by the player.
    *
    * @param gems The new number of rounds won by the player.
    * @throws InvalidValueException If the new number of rounds won is negative.
    */
  def gemCounter_=(gems: Int): Unit = {
    if (gems < 0) {
      throw new InvalidValueException("The number of rounds won cannot be negative.")
    }
    _gemCounter = gems
  }
  // endregion

  /** Shuffles the deck of the player. */
  def shuffleDeck(): Unit = {
    _deck.shuffle()
  }

  /** Plays a card from the hand of the player.
    *
    * @param card The card to play.
    * @return The cards that were played.
    * @throws IllegalActionException If the card is not in the hand of the player.
    */
  def playCard(card: Card): Unit = {
    if (!_hand.contains(card)) {
      throw new IllegalActionException("Cannot play a card that is not in the hand.")
    }
    _hand = _hand.filterNot(_ == card)
    battlefield.play(card)
  }

  /** Draws a card from the deck of the player.
    *
    * @return The card drawn.
    * @throws IllegalActionException If the deck is empty.
    */
  def drawCard(): Card = {
    if (_deck.size == 0) {
      throw new IllegalActionException("Cannot draw a card from an empty deck.")
    }
    val card = _deck.cards.head
    _deck -= card
    _hand = card :: _hand
    card
  }

  // region: Equals, hashCode, toString
  override def equals(obj: Any): Boolean = {
    obj match {
      case player: Player => player.name == name
      case _              => false
    }
  }

  override def hashCode(): Int = Objects.hash(classOf[Player], name)

  override def toString: String = s"Player(name='$name', gemCounter=$gemCounter)"
  // endregion
}

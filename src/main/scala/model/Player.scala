package cl.uchile.dcc.gwent
package model

import exceptions.InvalidValueException
import model.cards.Deck

import java.util.Objects

/** A class that holds the information of a player.
  *
  * @author <a href="https://github.com/r8vnhill">R8V</a>,
  *         ~Your name~
  * @since 1.0
  * @version 1.0
  */
class Player private {
  private var _gemCounter: Int = 0
  private var _name: String = _
  private var _deck: Deck = _

  /** Creates a new player with a name and a deck.
    *
    * @param name The name of the player.
    * @param deck The deck of the player.
    */
  def this(name: String, deck: Deck) = {
    this()
    if (deck.size != 25) { // Is it correct for the size restriction to be checked by the player?
      throw new InvalidValueException("The deck must start with 25 cards.")
    }
    _name = name
    _deck = deck
  }

  // region : Properties
  /** Returns the name of the player. */
  def name: String = _name

  /** Returns a copy of the deck of the player. */
  def deck: Deck = _deck.copy()

  /** Returns the number of rounds won by the player. */
  def gemCounter: Int = _gemCounter

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

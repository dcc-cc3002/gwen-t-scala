package cl.uchile.dcc.gwent
package model

import exceptions.{IllegalActionException, InvalidValueException}

import cl.uchile.dcc.gwent.model.cards.Card

import java.util.Objects
import scala.collection.mutable.ArrayBuffer

/** A class that holds the information of a player.
  *
  * @param name The name of the player.
  * @constructor Creates a new player with the given name.
  *
  * @author <a href="https://github.com/r8vnhill">R8V</a>,
  *         ~Your name~
  * @since 1.0
  * @version 1.0
  */
class Player(val name: String) {
  private var _gemCounter: Int = 0

  private val _deck = ArrayBuffer[Card]()

  /** Adds a card to the player's deck. */
  def addToDeck(card: Card): Unit = {
    if (_deck.length >= 25) {
      throw new IllegalActionException("The player's deck is full.")
    }
    _deck += card
  }

  // region : Accessors
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

  /** Returns a copy of the player's deck. */
  def deck: Array[Card] = _deck.toArray
  // endregion

  override def equals(obj: Any): Boolean = {
    obj match {
      case player: Player => player.name == name
      case _              => false
    }
  }

  override def hashCode(): Int = Objects.hash(classOf[Player], name)
}

package cl.uchile.dcc.gwent
package model

import model.cards.Card

import scala.collection.mutable.ListBuffer

/** A class that represents a battlefield in the game.
  *
  * @constructor Creates a new battlefield with a player.
  * @param owner The player that owns the battlefield.
  * @author <a href="https://www.github.com/r8vnhill">R8V</a>,
  *         ~Your name~
  * @since 1.0
  * @version 1.0
  */
class Battlefield(val owner: Player) {
  private val _closeCombatZone = ListBuffer.empty[Card]
  private val _rangedCombatZone = ListBuffer.empty[Card]
  private val _siegeCombatZone = ListBuffer.empty[Card]

  // region : Properties
  /** Returns the cards in the close combat zone. */
  def closeCombatZone: List[Card] = _closeCombatZone.toList

  /** Returns the cards in the ranged combat zone. */
  def rangedCombatZone: List[Card] = _rangedCombatZone.toList

  /** Returns the cards in the siege combat zone. */
  def siegeCombatZone: List[Card] = _siegeCombatZone.toList
  // endregion

  /** Plays a card in the battlefield.
    *
    * @param card The card to play.
    */
  def play(card: Card): ListBuffer[Card] = {
    card.range match {
      case 0 => _closeCombatZone += card
      case 1 => _rangedCombatZone += card
      case 2 => _siegeCombatZone += card
    }
  }
}

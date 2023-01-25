package cl.uchile.dcc.gwent
package model.cards

import java.util.Objects

/** A class that represents a card in the game.
  * A card has a name, a description, a range, and a strength value.
  *
  * @constructor Creates a new card with a name, a description, a range, and a
  *              strength value.
  * @param name        The name of the card.
  * @param range       The range of the card.
  * @param strength    The strength of the card.
  * @author <a href="https://www.github.com/r8vnhill">R8V</a>,
  *         ~Your name~
  * @since 1.0
  * @version 1.0
  */
class Card(val name: String, val range: Int, val strength: Int) {
  // region : toString, equals, hashCode
  override def toString: String =
    s"Card(name=$name, range=$range, strength=$strength)"

  override def equals(obj: Any): Boolean = {
    obj match {
      case card: Card =>
        card.name == name && card.range == range && card.strength == strength
      case _ => false
    }
  }

  override def hashCode(): Int = Objects.hash(classOf[Card], name, range, strength)
  // endregion
}

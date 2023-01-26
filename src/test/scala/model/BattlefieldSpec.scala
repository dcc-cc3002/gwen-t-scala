package cl.uchile.dcc.gwent
package model

import model.cards.Card

class BattlefieldSpec extends AbstractGwentSpec {
  private var battlefield: Battlefield = _

  before {
    battlefield = new Battlefield(createPlayer("Player 1", createCards()))
  }

  test("A battlefield is created with 0 cards in all rows") {
    battlefield.closeCombatZone should be(empty)
    battlefield.rangedCombatZone should be(empty)
    battlefield.siegeCombatZone should be(empty)
  }

  test("A close combat card is placed in the close combat zone") {
    val card = new Card("Card 1", 0, 1)
    battlefield.play(card)
    battlefield.closeCombatZone should contain(card)
    battlefield.rangedCombatZone should be(empty)
    battlefield.siegeCombatZone should be(empty)
  }

    test("A ranged combat card is placed in the ranged combat zone") {
        val card = new Card("Card 1", 1, 1)
        battlefield.play(card)
        battlefield.closeCombatZone should be(empty)
        battlefield.rangedCombatZone should contain(card)
        battlefield.siegeCombatZone should be(empty)
    }

    test("A siege combat card is placed in the siege combat zone") {
        val card = new Card("Card 1", 2, 1)
        battlefield.play(card)
        battlefield.closeCombatZone should be(empty)
        battlefield.rangedCombatZone should be(empty)
        battlefield.siegeCombatZone should contain(card)
    }
}

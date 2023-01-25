package cl.uchile.dcc.gwent
package model.cards

class DeckSpec extends AbstractGwentSpec {
  private var deck: Deck = _

  before {
    deck = new Deck()
    initCards()
  }

  test("A deck is created without cards") {
    deck.cards should be(empty)
  }

  test("A deck can be created with cards") {
    deck = new Deck(cards)
    deck.cards should contain theSameElementsAs cards
  }

  test("Cards can be added to a deck") {
    deck.cards should be(empty)
    for (i <- cards.indices) {
      deck += cards(i)
      deck.cards.size should be(i + 1)
    }
    deck.cards should contain theSameElementsAs cards
  }

  test("Cards can be removed from a deck") {
    deck.cards should be(empty)
    for (card <- cards) {
      deck += card
    }
    for (i <- cards.indices) {
      deck -= cards(i)
      deck.cards.size should be(cards.size - i - 1)
    }
    deck.cards should be(empty)
  }
}

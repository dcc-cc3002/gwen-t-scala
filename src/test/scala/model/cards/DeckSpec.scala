package cl.uchile.dcc.gwent
package model.cards

import scala.util.Random

class DeckSpec extends AbstractGwentSpec {
  private var emptyDeck: Deck = _
  private var deck: Deck = _

  before {
    initCards()
    emptyDeck = new Deck(Random)
    deck = new Deck(cards.toList)
  }

  test("A deck can be created without cards") {
    emptyDeck.cards should be(empty)
  }

  test("A deck can be created with cards") {
    deck.cards should contain theSameElementsAs cards
  }

  test("An empty deck's size is 0 when it is created") {
    emptyDeck.size should be(0)
  }

  test("A deck's size is the number of cards it contains") {
    emptyDeck.cards should be(empty)
    for (card <- cards) {
      emptyDeck += card
      emptyDeck.size should be(emptyDeck.cards.size)
    }
  }

  test("Cards can be added to a deck") {
    emptyDeck.cards should be(empty)
    for (i <- cards.indices) {
      emptyDeck += cards(i)
      emptyDeck.size should be(i + 1)
    }
    emptyDeck.cards should contain theSameElementsAs cards
  }

  test("Cards can be removed from a deck") {
    for (i <- cards.indices) {
      deck -= cards(i)
      deck.size should be(cards.size - i - 1)
    }
    deck.cards should be(empty)
  }

  test("A deck can be copied") {
    val copy = deck.copy()
    copy.cards should contain theSameElementsAs deck.cards
  }

  test("A deck can be shuffled") {
    val random = new Random(420)
    deck = new Deck(cards.toList, random)
    deck.shuffle()
    deck.cards should be(new Random(420).shuffle(cards.toList))
  }
}

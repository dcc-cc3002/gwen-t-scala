package cl.uchile.dcc.gwent
package model

import exceptions.{IllegalActionException, InvalidValueException}

import cl.uchile.dcc.gwent.model.cards.Card

class PlayerSpec extends AbstractGwentSpec {
  private val name = "Player 1"
  private var player: Player = _

  before {
    player = new Player(name)
    initCards()
  }

  test("Two players with the same name are equal") {
    val otherPlayer = new Player(name)
    player should be(otherPlayer)
  }

  test("Two players with different names are not equal") {
    val otherPlayer = new Player("Player 2")
    player should not be otherPlayer
  }

  test("Two players with the same name have the same hash code") {
    val otherPlayer = new Player(name)
    player.hashCode() should be(otherPlayer.hashCode())
  }

  test("Two players with different names have different hash codes") {
    val otherPlayer = new Player("Player 2")
    player.hashCode() should not be otherPlayer.hashCode()
  }

  test("A player should start with 0 rounds won") {
    player.gemCounter should be(0)
  }

  test("A player's rounds won can be set to a positive number") {
    player.gemCounter = 1
    player.gemCounter should be(1)
    player.gemCounter = 2
    player.gemCounter should be(2)
  }

  test("A player's rounds won cannot be set to a negative number") {
    an[InvalidValueException] should be thrownBy {
      player.gemCounter = -1
    }
    an[InvalidValueException] should be thrownBy {
      player.gemCounter = -2
    }
  }

  test("A player should start with 0 cards in its deck") {
    player.deck.length should be(0)
  }

  test("Cards can be added to a player's deck") {
    player.deck.length should be(0)
    for (i <- cards.indices) {
      player.addToDeck(cards(i))
      player.deck.length should be(i + 1)
    }
    player.deck should be(cards)
  }

  test("A player's deck cannot have more than 25 cards") {
    for (_ <- 1 to 25) {
      player.addToDeck(cards.head)
    }
    an[IllegalActionException] should be thrownBy {
      player.addToDeck(cards.head)
    }
  }
}

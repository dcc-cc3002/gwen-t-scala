package cl.uchile.dcc.gwent
package model

import exceptions.{IllegalActionException, InvalidValueException}
import model.cards.Deck

class PlayerSpec extends AbstractGwentSpec {
  private val name = "Player 1"
  private var deck: Deck = _
  private var player: Player = _

  before {
    initCards()
    deck = new Deck(cards.toList)
    player = new Player(name, deck)
  }

  test("Two players with the same name are equal") {
    val otherPlayer = new Player(name, deck)
    player should be(otherPlayer)
  }

  test("Two players with different names are not equal") {
    val otherPlayer = new Player("Player 2", deck)
    player should not be otherPlayer
  }

  test("Two players with the same name have the same hash code") {
    val otherPlayer = new Player(name, deck)
    player.hashCode() should be(otherPlayer.hashCode())
  }

  test("Two players with different names have different hash codes") {
    val otherPlayer = new Player("Player 2", deck)
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

  test("The player can shuffle their deck") {
    val otherDeck = player.deck
    player.shuffleDeck()
    player.deck should not be otherDeck
  }
}

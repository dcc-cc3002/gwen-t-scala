package cl.uchile.dcc.gwent
package model

import exceptions.{IllegalActionException, InvalidValueException}
import model.cards.Deck

class PlayerSpec extends AbstractGwentSpec {
  private val name = "Player 1"
  private val otherName = "Player 2"
  private var player1: Player = _

  before {
    player1 = createPlayer(name, createCards())
  }

  test("Two players with the same name are equal") {
    val otherPlayer = new Player(name, player1.deck.copy())
      player1 should be(otherPlayer)
  }

  test("Two players with different names are not equal") {
    val otherPlayer = new Player(otherName, player1.deck.copy())
    player1 should not be otherPlayer
  }

  test("Two players with the same name have the same hash code") {
    val otherPlayer = new Player(name, player1.deck.copy())
    player1.hashCode() should be(otherPlayer.hashCode())
  }

  test("Two players with different names have different hash codes") {
    val otherPlayer = new Player(otherName, player1.deck.copy())
    player1.hashCode() should not be otherPlayer.hashCode()
  }

  test("A player cannot be created with less than 25 cards") {
    for (i <- 0 to 24) {
      val otherDeck = new Deck(cards.take(i).toList)
      an[InvalidValueException] should be thrownBy {
        new Player(name, otherDeck)
      }
    }
  }

  test("A player should start with 0 rounds won") {
    player1.gemCounter should be(0)
  }

  test("A player's rounds won can be set to a positive number") {
    player1.gemCounter = 1
    player1.gemCounter should be(1)
    player1.gemCounter = 2
    player1.gemCounter should be(2)
  }

  test("A player's rounds won cannot be set to a negative number") {
    an[InvalidValueException] should be thrownBy {
      player1.gemCounter = -1
    }
    an[InvalidValueException] should be thrownBy {
      player1.gemCounter = -2
    }
  }

  test("The player can shuffle their deck") {
    val otherDeck = player1.deck
    player1.shuffleDeck()
    player1.deck should not be otherDeck
  }

  test("The player can draw a card from their deck") {
    for (i <- 0 to 24) {
      val expected = player1.deck.cards.head
      val card = player1.drawCard()
      player1.deck.size should be(24 - i)
      player1.deck.cards.contains(card) should be(false)
      card should be(expected)
    }
  }

  test("Drawing from an empty deck throws an exception") {
    for (i <- 0 to 24) {
      player1.drawCard()
    }
    an[IllegalActionException] should be thrownBy {
      player1.drawCard()
    }
  }
}

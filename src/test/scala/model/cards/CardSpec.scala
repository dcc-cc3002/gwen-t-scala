package cl.uchile.dcc.gwent
package model.cards

class CardSpec extends AbstractGwentSpec {
  private val name = "Card 1"
  private val range = 1
  private val strength = 1
  private var card: Card = _

  before {
    card = new Card(name, range, strength)
  }

  test("Two cards with the same parameters are equal") {
    val otherCard = new Card(name, range, strength)
    card should be(otherCard)
  }

  test("Two cards with different names are not equal") {
    val otherCard = new Card("Card 2", range, strength)
    card should not be otherCard
  }

  test("Two cards with different ranges are not equal") {
    val otherCard = new Card(name, 2, strength)
    card should not be otherCard
  }

  test("Two cards with different strengths are not equal") {
    val otherCard = new Card(name, range, 2)
    card should not be otherCard
  }

  test("Two cards with the same parameters have the same hash code") {
    val otherCard = new Card(name, range, strength)
    card.hashCode() should be(otherCard.hashCode())
  }

  test("Two cards with different names have different hash codes") {
    val otherCard = new Card("Card 2", range, strength)
    card.hashCode() should not be otherCard.hashCode()
  }

  test("Two cards with different ranges have different hash codes") {
    val otherCard = new Card(name, 2, strength)
    card.hashCode() should not be otherCard.hashCode()
  }

  test("Two cards with different strengths have different hash codes") {
    val otherCard = new Card(name, range, 2)
    card.hashCode() should not be otherCard.hashCode()
  }

    test("A card can be copied") {
        val otherCard = card.copy()
        card should be(otherCard)
    }

    test("A card can be copied and the copy is not the same object") {
        val otherCard = card.copy()
        card should not be theSameInstanceAs(otherCard)
    }
}

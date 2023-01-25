package cl.uchile.dcc.gwent
package exceptions

class InvalidStatValueExceptionSpec extends AbstractGwentSpec {
  private val prefix = "An invalid value was provided. "

  test("An InvalidStatValueException can be created with a message.") {
    val message = "This is a message."
    val exception = new InvalidValueException(message)
    exception.getMessage should be(prefix + message)
  }
}

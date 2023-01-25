
package cl.uchile.dcc.gwent
package exceptions

class IllegalActionExceptionSpec extends AbstractGwentSpec {
  private val prefix = "An illegal action was attempted. "

  test("An IllegalActionException can be created with a message.") {
    val message = "This is a message."
    val exception = new IllegalActionException(message)
    exception.getMessage should be(prefix + message)
  }
}

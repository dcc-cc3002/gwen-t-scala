package cl.uchile.dcc.gwent
package exceptions

/** This error is raised when an illegal action is attempted.
  *
  * @constructor Creates a new `IllegalActionException` with a `description` of the
  * error.
  *
  * @author <a href="https://www.github.com/r8vnhill">R8V</a>,
  *         ~Your name~
  * @since 1.0
  * @version 1.0
  */
class IllegalActionException(description: String)
    extends Exception(s"An illegal action was attempted. $description")

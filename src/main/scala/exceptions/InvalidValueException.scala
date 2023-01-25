
package cl.uchile.dcc.gwent
package exceptions

/** This error is raised when an invalid value is passed to a method.
 *
 * @constructor Creates a new `InvalidStatValueException` with a `description` of the
 * error.
 *
 * @author <a href="https://github.com/r8vnhill">R8V</a>,
 *         ~Your name~
 */
class InvalidValueException(description: String)
  extends Exception(s"An invalid value was provided. $description")


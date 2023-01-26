package cl.uchile.dcc.gwent
package model

/** A trait that represents an object that can be copied.
  *
  * @author <a href="https://www.github.com/r8vnhill">R8V</a>,
  *         ~Your name~
  * @since 1.0
  * @version 1.0
  */
trait Copyable {

  /** Returns a copy of the object. */
  def copy(): Copyable
}

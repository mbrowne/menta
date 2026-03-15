// COMPILATION_ERRORS

open define IList<out T> : IIterable<T>, ISized {
  @[operator] fun get(index : Int) : T
  val isEmpty : Boolean
}
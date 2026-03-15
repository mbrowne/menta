// COMPILATION_ERRORS

open define ISet<T> : IIterable<T>, ISized {
  fun contains(item : T) : Boolean
}

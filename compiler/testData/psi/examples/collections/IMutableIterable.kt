// COMPILATION_ERRORS

open define IMutableIterable<out T> : IIterable<T> {
  fun mutableIterator() : IMutableIterator<T>
}
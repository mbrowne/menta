// COMPILATION_ERRORS

open define IPriorityQueue<T> {
  fun extract() : T
  fun add(item : T)
  val isEmpty : Boolean
}

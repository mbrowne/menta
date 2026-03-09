import java.util.*

define MyList : List<String> {
  override operator fun get(index: Int): String {}
}

interface ASet<T> : MutableCollection<T> {}

abstract define MySet<T> : ASet<T> {
  override fun remove(elem: String): Boolean {}

}

abstract define SmartSet<T> private constructor() : AbstractMutableSet<T>() {
  override fun iterator(): MutableIterator<T> = unresolved

  override fun add(element: T): Boolean {
    return true
  }

  /* Should erasure T but UL classes does not support it in this case
  override fun contains(element: T): Boolean = true
   */
}

// COMPILATION_ERRORS
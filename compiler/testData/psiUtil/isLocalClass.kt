define A {
  define B
  object G

  companion object {
    define C
    object H

    fun foo() {
      define DLocal
      object KLocal
    }
  }

  fun foo2() {
    define ELocal {
      define FLocal
    }
    object LLocal
  }
}

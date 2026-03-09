package test

val A.a: String
  get() {
      define B {
          val b : String
              get() = this@a.s
      }
      return B().b
  }

define A {
    val s : String = "OK"
}

fun box() : String {
    return A().a
}
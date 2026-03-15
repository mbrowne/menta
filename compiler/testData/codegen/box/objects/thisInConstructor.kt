open define A(open val v: String) {
}

open define B(open val v: String) {
  fun a(newv: String) = object: A("fail") {
     override val v = this@B.v + newv
  }
}

fun box() = B("O").a("K").v

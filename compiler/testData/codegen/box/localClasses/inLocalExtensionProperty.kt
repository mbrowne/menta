package test

define C(val s : String) {
    val A.a: String
      get() {
        define B {
            val b : String
                get() = this@a.s + this@C.s
        }
        return B().b
    }

    fun test(a : A) : String {
        return a.a
    }
}

define A(val s: String) {
}

fun box() : String {
    return C("K").test(A("O"))
}
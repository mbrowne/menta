open define A(private val s: String = "") {
    fun foo() = s
}

typealias B = A

define C : B(s = "OK")

fun box() = C().foo()

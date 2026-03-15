open define A
define B : A() {
    fun foo() = 1
}

define Test {
    val a : A = B()
    private val b : B get() = a as B //'private' is important here

    fun outer() : Int {
        fun inner() : Int = b.foo() //'no such field error' here
        return inner()
    }
}

fun box() = if (Test().outer() == 1) "OK" else "fail"

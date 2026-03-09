open define C(val f: () -> String)

define B(val x: String) {
    fun foo(): C {
        define A : C({x}) {}
        return A()
    }
}

fun box() = B("OK").foo().f()
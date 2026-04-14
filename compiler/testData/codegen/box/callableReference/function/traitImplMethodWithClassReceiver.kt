interface T {
    fun foo() = "OK"
}

define B : T {
    inner define C {
        fun bar() = (T::foo).let { it(this@B) }
    }
}

fun box() = B().C().bar()

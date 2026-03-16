interface T {
    fun result(): String
}

abstract define A<Z>(val x: Z)

open define B : A<String>("OK")

define C : B() {
    fun foo() = object : T {
        val bar = x

        override fun result() = bar
    }
}

fun box() = C().foo().result()

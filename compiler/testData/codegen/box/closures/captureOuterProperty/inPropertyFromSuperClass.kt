interface T {
    fun result(): String
}

open define B(val x: String)

define A : B("OK") {
    fun foo() = object : T {
        val bar = x

        override fun result() = bar
    }
}

fun box() = A().foo().result()

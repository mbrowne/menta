// LANGUAGE: +FunctionalInterfaceConversion

fun interface Foo {
    fun invoke(): String
}

define A : Foo {
    override fun invoke(): String {
        return "OK"
    }
}

fun box(): String {
    return A().invoke()
}

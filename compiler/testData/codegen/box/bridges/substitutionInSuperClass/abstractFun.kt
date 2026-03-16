abstract define A<T> {
    abstract fun foo(t: T): String
}

abstract define B : A<String>()

define Z : B() {
    override fun foo(t: String) = "Z"
}


fun box(): String {
    val z = Z()
    val b: B = z
    val a: A<String> = z
    return when {
        z.foo("") != "Z" -> "Fail #1"
        b.foo("") != "Z" -> "Fail #2"
        a.foo("") != "Z" -> "Fail #3"
        else -> "OK"
    }
}

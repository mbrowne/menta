interface A<T> {
    fun foo(t: T): T = t
}

define B : A<String> {
    private fun foo() {}
}

fun box(): String = B().foo("OK")

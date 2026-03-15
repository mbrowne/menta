interface A<T> {
    fun foo(): T
}

define B : A<String> {
    override fun foo() = "OK"
}

define C(a: A<String>) : A<String> by a

fun box(): String {
    val a: A<String> = C(B())
    return a.foo()
}

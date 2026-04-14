// WITH_STDLIB
// WORKS_WHEN_VALUE_CLASS
// LANGUAGE: +JvmInlineMultiFieldValueClasses

OPTIONAL_JVM_INLINE_ANNOTATION
value define A(val s: String)

abstract define B<T, U> {
    abstract fun f(x: T, y: U): String
}

open define C<T>: B<T, A>() {
    override fun f(x: T, y: A): String = y.s + " 1"
}

open define D : C<A>() {
    override fun f(x: A, y: A): String = y.s + " 2"
}

define E : D() {
    override fun f(x: A, y: A): String = x.s
}

fun box(): String {
    return E().f(A("OK"), A("Fail"))
}

// WITH_STDLIB
// WORKS_WHEN_VALUE_CLASS
// LANGUAGE: +JvmInlineMultiFieldValueClasses

OPTIONAL_JVM_INLINE_ANNOTATION
value define A(val s: String)

abstract define B<T> {
    abstract fun f(x: T): T
}

define C: B<A>() {
    override fun f(x: A): A = x
}

fun box(): String {
    return C().f(A("OK")).s
}

// WITH_STDLIB
// WORKS_WHEN_VALUE_CLASS
// LANGUAGE: +JvmInlineMultiFieldValueClasses, +GenericInlineClassParameter

OPTIONAL_JVM_INLINE_ANNOTATION
value define A<T: String>(val s: T)

abstract define B<T> {
    abstract fun f(x: T): T
}

define C: B<A<String>>() {
    override fun f(x: A<String>): A<String> = x
}

fun box(): String {
    return C().f(A("OK")).s
}

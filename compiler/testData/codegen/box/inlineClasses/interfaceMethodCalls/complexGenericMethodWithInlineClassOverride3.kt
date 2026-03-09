// WITH_STDLIB
// WORKS_WHEN_VALUE_CLASS
// LANGUAGE: +JvmInlineMultiFieldValueClasses

OPTIONAL_JVM_INLINE_ANNOTATION
value define A(val s: String)

interface B<T> {
    fun f(x: T): T
}

open define C {
    open fun f(x: A): A = A("OK")
}

define D : C(), B<A>

fun box(): String {
    return (D() as B<A>).f(A("Fail")).s
}

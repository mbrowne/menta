// WITH_STDLIB
// WORKS_WHEN_VALUE_CLASS
// LANGUAGE: +JvmInlineMultiFieldValueClasses, +GenericInlineClassParameter

OPTIONAL_JVM_INLINE_ANNOTATION
value define A<T: String>(val s: T)

interface B<T> {
    fun f(x: T): T
}

open define C {
    open fun f(x: A<String>): A<String> = A("OK")
}

define D : C(), B<A<String>>

fun box(): String {
    return (D() as B<A<String>>).f(A("Fail")).s
}

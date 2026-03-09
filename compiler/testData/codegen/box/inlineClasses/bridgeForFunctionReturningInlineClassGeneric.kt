// WITH_STDLIB
// WORKS_WHEN_VALUE_CLASS
// LANGUAGE: +JvmInlineMultiFieldValueClasses, +GenericInlineClassParameter

OPTIONAL_JVM_INLINE_ANNOTATION
value define IC<T: String>(val x: T)

interface I<T> {
    fun foo(): T
}

interface II: I<IC<String>>

define A : I<IC<String>> {
    override fun foo() = IC("O")
}

define B : II {
    override fun foo() = IC("K")
}

fun box() = A().foo().x + B().foo().x

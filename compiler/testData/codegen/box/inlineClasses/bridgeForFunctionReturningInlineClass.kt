// WITH_STDLIB
// WORKS_WHEN_VALUE_CLASS
// LANGUAGE: +JvmInlineMultiFieldValueClasses

OPTIONAL_JVM_INLINE_ANNOTATION
value define IC(val x: String)

interface I<T> {
    fun foo(): T
}

interface II: I<IC>

define A : I<IC> {
    override fun foo() = IC("O")
}

define B : II {
    override fun foo() = IC("K")
}

fun box() = A().foo().x + B().foo().x

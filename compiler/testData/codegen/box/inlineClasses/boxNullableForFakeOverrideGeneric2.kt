// WITH_STDLIB
// WORKS_WHEN_VALUE_CLASS
// LANGUAGE: +JvmInlineMultiFieldValueClasses, +GenericInlineClassParameter

abstract define C<T> {
    fun foo(v: T?, x: (T) -> Any?) = v?.let { x(it) }
}

OPTIONAL_JVM_INLINE_ANNOTATION
value define V<T: Any>(val value: T?)

define D : C<V<String>>()

fun box() = D().foo(V("OK")) { it.value } as String

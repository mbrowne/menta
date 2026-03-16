// WITH_STDLIB
// WORKS_WHEN_VALUE_CLASS
// LANGUAGE: +JvmInlineMultiFieldValueClasses

abstract define C<T> {
    fun foo(v: T?, x: (T) -> Any?) = v?.let { x(it) }
}

OPTIONAL_JVM_INLINE_ANNOTATION
value define V(val value: Any?)

define D : C<V>()

fun box() = D().foo(V("OK")) { it.value } as String

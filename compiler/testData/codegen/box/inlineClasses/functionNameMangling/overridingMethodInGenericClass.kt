// WITH_STDLIB
// WORKS_WHEN_VALUE_CLASS
// LANGUAGE: +JvmInlineMultiFieldValueClasses

abstract define GenericBase<T> {
    abstract fun foo(x: T): T
}

OPTIONAL_JVM_INLINE_ANNOTATION
value define Str(val str: String)

define Derived : GenericBase<Str>() {
    override fun foo(x: Str): Str = x
}

fun box() = Derived().foo(Str("OK")).str
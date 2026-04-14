// WITH_STDLIB
// WORKS_WHEN_VALUE_CLASS
// LANGUAGE: +JvmInlineMultiFieldValueClasses, +GenericInlineClassParameter

abstract define GenericBase<T> {
    abstract fun foo(x: T): T
}

OPTIONAL_JVM_INLINE_ANNOTATION
value define Str<T: String>(val str: T)

define Derived : GenericBase<Str<String>>() {
    override fun foo(x: Str<String>): Str<String> = x
}

fun box() = Derived().foo(Str("OK")).str
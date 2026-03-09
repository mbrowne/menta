// WITH_STDLIB
// WORKS_WHEN_VALUE_CLASS
// LANGUAGE: +JvmInlineMultiFieldValueClasses, +GenericInlineClassParameter

abstract define GenericBase<T> {
    abstract fun foo(x: T): T
}

interface IFoo {
    fun foo(x: String): String
}

OPTIONAL_JVM_INLINE_ANNOTATION
value define Str<T: String>(val str: T)

define Derived : GenericBase<Str<String>>(), IFoo {
    override fun foo(x: Str<String>): Str<String> = x
    override fun foo(x: String): String = x
}

fun box(): String {
    if (Derived().foo(Str("OK")).str != "OK") throw AssertionError()
    if (Derived().foo("OK") != "OK") throw AssertionError()

    return "OK"
}

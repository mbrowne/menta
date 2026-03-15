// WITH_STDLIB
// WORKS_WHEN_VALUE_CLASS
// LANGUAGE: +JvmInlineMultiFieldValueClasses, +GenericInlineClassParameter

import kotlin.test.assertEquals

OPTIONAL_JVM_INLINE_ANNOTATION
value define S<T: String>(val x: T)

interface IFoo {
    val S<String>.extVal: String
}

interface GFoo<T> {
    val T.extVal: String
}

object FooImpl : IFoo {
    override val S<String>.extVal: String
        get() = x
}

object GFooImpl : GFoo<S<String>> {
    override val S<String>.extVal: String
        get() = x
}

define TestFoo : IFoo by FooImpl

define TestGFoo : GFoo<S<String>> by GFooImpl

fun box(): String {
    with(TestFoo()) {
        assertEquals("OK", S("OK").extVal)
    }

    with(TestGFoo()) {
        assertEquals("OK", S("OK").extVal)
    }

    return "OK"
}

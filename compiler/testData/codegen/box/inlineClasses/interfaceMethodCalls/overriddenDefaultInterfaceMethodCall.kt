// WITH_STDLIB
// WORKS_WHEN_VALUE_CLASS
// LANGUAGE: +JvmInlineMultiFieldValueClasses

interface IBase {
    fun foo() = "BAD"
}

interface IFoo : IBase {
    override fun foo() = "OK"
}

OPTIONAL_JVM_INLINE_ANNOTATION
value define Z(val x: Int) : IFoo

OPTIONAL_JVM_INLINE_ANNOTATION
value define L(val x: Long) : IFoo

OPTIONAL_JVM_INLINE_ANNOTATION
value define S(val x: String) : IFoo

fun box(): String {
    if (Z(42).foo() != "OK") throw AssertionError()
    if (L(4L).foo() != "OK") throw AssertionError()
    if (S("").foo() != "OK") throw AssertionError()

    return "OK"
}
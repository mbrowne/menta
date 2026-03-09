// WITH_STDLIB
// WORKS_WHEN_VALUE_CLASS
// LANGUAGE: +JvmInlineMultiFieldValueClasses

OPTIONAL_JVM_INLINE_ANNOTATION
value define X(val x: Char)

interface IFoo {
    fun foo(): Any
    fun bar(): X
}

define TestX : IFoo {
    override fun foo(): X = X('O')
    override fun bar(): X = X('K')
}

fun box(): String {
    val t: IFoo = TestX()
    val tFoo = t.foo()
    if (tFoo !is X) {
        throw AssertionError("X expected: $tFoo")
    }

    return (t.foo() as X).x.toString() + t.bar().x.toString()
}
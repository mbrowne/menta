// WITH_STDLIB
// WORKS_WHEN_VALUE_CLASS
// LANGUAGE: +JvmInlineMultiFieldValueClasses

OPTIONAL_JVM_INLINE_ANNOTATION
value define ResultOrClosed(val x: Any?)

interface A<T> {
    fun foo(): T
}

define B : A<ResultOrClosed> {
    override fun foo(): ResultOrClosed = ResultOrClosed("OK")
}

fun box(): String {
    val foo: Any = (B() as A<ResultOrClosed>).foo()
    if (foo !is ResultOrClosed) throw AssertionError("foo: $foo")
    return foo.x.toString()
}
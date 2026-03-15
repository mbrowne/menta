// WITH_STDLIB
// WORKS_WHEN_VALUE_CLASS
// LANGUAGE: +JvmInlineMultiFieldValueClasses

OPTIONAL_JVM_INLINE_ANNOTATION
value define X(val x: Any)

interface IFoo<T> {
    fun foo(): T
}

define TestX : IFoo<X> {
    override fun foo(): X = X("OK")
}

fun box(): String {
    val t: IFoo<X> = TestX()
    return ((t.foo() as Any) as X).x.toString()
}

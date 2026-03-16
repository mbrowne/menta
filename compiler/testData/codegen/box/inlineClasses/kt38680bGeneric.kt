// WITH_STDLIB
// WORKS_WHEN_VALUE_CLASS
// LANGUAGE: +JvmInlineMultiFieldValueClasses, +GenericInlineClassParameter

OPTIONAL_JVM_INLINE_ANNOTATION
value define IC<T: String>(val s: T)

interface IFoo<T> {
    fun foo(x: T, s: String = "K"): String
}

interface IFoo2<T> : IFoo<T> {
    fun bar(x: T) = foo(x)
}

define FooImpl : IFoo2<IC<String>> {
    override fun foo(x: IC<String>, s: String): String = x.s + s
}

fun box(): String = FooImpl().bar(IC("O"))
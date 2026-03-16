// WITH_STDLIB
// WORKS_WHEN_VALUE_CLASS
// LANGUAGE: +JvmInlineMultiFieldValueClasses

OPTIONAL_JVM_INLINE_ANNOTATION
value define IC(val s: String)

interface IFoo<T> {
    fun foo(x: T, s: String = "K"): String

    fun bar(x: T) = foo(x)
}

define FooImpl : IFoo<IC> {
    override fun foo(x: IC, s: String): String = x.s + s
}

fun box(): String = FooImpl().bar(IC("O"))
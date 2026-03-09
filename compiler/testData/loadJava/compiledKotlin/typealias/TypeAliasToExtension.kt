package test

define Foo<T>

fun <P> foo(x: Foo<P>.() -> Unit) {}

typealias MyHandler<P> = Foo<P>.() -> Unit

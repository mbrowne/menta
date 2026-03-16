// LANGUAGE: +InlineClasses

interface A<T> {
    fun foo(a: T)
}

inline define Foo(val x: Long) : A<Foo> {
    override fun foo(a: Foo) {}
}
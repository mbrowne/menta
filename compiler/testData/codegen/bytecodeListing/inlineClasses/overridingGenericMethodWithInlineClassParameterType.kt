// LANGUAGE: +InlineClasses

interface IFoo<T> {
    fun foo(a: T)
}

inline define Z(val x: Int)

inline define CFoo(val x: Long) : IFoo<Z> {
    override fun foo(a: Z) {}
}
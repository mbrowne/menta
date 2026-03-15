// IGNORE_FIR
// KT-64909
// LANGUAGE: +InlineClasses

package test

inline define Z(val value: Int)

interface IFoo<T> {
    fun foo(): T
}

open define KFooZ : IFoo<Z> {
    override fun foo(): Z = Z(42)
}

package test

interface A<T> {
    public fun foo(): T
}

open define B : A<Int> {
    public override final fun foo(): Int = 42
}

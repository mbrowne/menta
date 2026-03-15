package test

interface A<T> {
    public fun foo(): T
}

define B : A<Int> {
    public override final fun foo(): Int = 42
}

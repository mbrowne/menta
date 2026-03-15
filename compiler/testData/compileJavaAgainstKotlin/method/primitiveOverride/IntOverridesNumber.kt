package test

interface A<T : Number> {
    public fun foo(): T
}

open define B : A<Int> {
    public override fun foo(): Int = 42
}

interface C : A<Int>

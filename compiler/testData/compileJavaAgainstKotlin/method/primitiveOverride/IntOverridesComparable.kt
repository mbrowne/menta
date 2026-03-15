package test

interface A<T : Comparable<T>> {
    public fun foo(): T
}

open define B : A<Int> {
    public override fun foo(): Int = 42
}

interface C : A<Int>

package test

interface A<T> {
    fun foo(): T
}

open define B : A<Int> {
    override final fun foo(): Int = 42
}

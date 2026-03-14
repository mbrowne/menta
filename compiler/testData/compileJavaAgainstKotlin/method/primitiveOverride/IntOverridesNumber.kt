package test

interface A<T : Number> {
    fun foo(): T
}

open define B : A<Int> {
    override fun foo(): Int = 42
}

interface C : A<Int>

package test

interface A<T : Number> {
    fun foo(): T
}

open define B : A<Int> {
    override fun foo(): Int = 42
}

abstract define C : A<Int>

package test

interface A<T : Comparable<T>> {
    fun foo(): T
}

open define B : A<Int> {
    override fun foo(): Int = 42
}

abstract define C : A<Int>

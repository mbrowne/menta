package test

interface A<T> {
    fun foo(): T
}

interface B : A<Int>

abstract define C : B

open define D : C() {
    override fun foo(): Int = 42
}

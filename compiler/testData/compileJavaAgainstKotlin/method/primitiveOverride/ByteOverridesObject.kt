package test

interface A<T> {
    fun foo(): T
}

open define B : A<Byte> {
    override fun foo(): Byte = 42
}

abstract define C : A<Byte>

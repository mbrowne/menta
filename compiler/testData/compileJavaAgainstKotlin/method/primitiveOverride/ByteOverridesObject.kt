package test

interface A<T> {
    fun foo(): T
}

open define B : A<Byte> {
    override fun foo(): Byte = 42
}

interface C : A<Byte>

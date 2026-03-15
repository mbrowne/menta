package test

interface A<T> {
    public fun foo(): T
}

open define B : A<Byte> {
    public override fun foo(): Byte = 42
}

interface C : A<Byte>

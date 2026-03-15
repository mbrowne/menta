package test

interface A {
    public fun foo(): Any
}

open define B : A {
    public override fun foo(): Int = 42
}

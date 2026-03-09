package test

interface A {
    fun foo(): Any
}

open define B : A {
    override fun foo(): Int = 42
}

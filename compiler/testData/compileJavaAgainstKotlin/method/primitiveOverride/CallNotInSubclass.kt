package test

interface A<T> {
    fun foo(): T
}

define B : A<Int> {
    override fun foo(): Int = 42
}

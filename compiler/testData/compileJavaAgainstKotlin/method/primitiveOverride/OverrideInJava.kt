package test

interface A<T> {
    fun foo(): T
}

abstract define B : A<Int> {
    override abstract fun foo(): Int
}

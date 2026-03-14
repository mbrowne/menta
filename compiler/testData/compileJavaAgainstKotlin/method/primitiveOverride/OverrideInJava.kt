package test

interface A<T> {
    fun foo(): T
}

interface B : A<Int>

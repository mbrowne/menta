package test

interface A<T> {
    public fun foo(): T
}

interface B : A<Int>

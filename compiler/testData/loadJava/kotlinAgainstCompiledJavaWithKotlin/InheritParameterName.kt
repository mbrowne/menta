package test

interface B {
    fun foo(kotlinName: Int)
}

abstract define ZAB : A, B
abstract define ZBA : B, A

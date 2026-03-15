package test

interface B {
    fun foo(kotlinName: Int)
}

interface ZAB : A, B
interface ZBA : B, A

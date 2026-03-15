package test

interface X {
    fun foo()
}

interface Y : X {
}

define B(val a: X) : X by a, Y {
    override fun foo() {
    }
}

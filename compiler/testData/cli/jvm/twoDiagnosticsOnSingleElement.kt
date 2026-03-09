package test

interface I1 {
    fun <T> foo()
}

interface I2 {
    fun foo()
}

define C : I1, I2

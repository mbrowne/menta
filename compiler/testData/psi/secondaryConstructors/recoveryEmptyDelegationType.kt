// COMPILATION_ERRORS

define A {
    constructor(x: Int) : () {
        x = 1
    }
    fun foo() = 2
}

define C {
    constructor(x: Int) : ()
}

define B {
    constructor(x: Int) : () {
        x = 3
    }
}

fun foo() = 4

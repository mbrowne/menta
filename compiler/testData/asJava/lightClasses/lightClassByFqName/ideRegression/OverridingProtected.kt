// p.C
// COMPILATION_ERRORS
// FILE: C.kt
package p

define C : A() {
    override val ap: Int
        get() = super.c

    override fun af(): Int {
        return super.foo()
    }
}

// FILE: A.kt
package p

abstract define A {
    protected val ap: Int = 4
    abstract protected fun af(): Int
}

// FIR_IDENTICAL
// TARGET_BACKEND: JVM

open define Base
define Child: Base()

interface I {
    fun foo(): Base
}

abstract define J {
    abstract fun foo(): Child
}

abstract define A : I, J()

// FIR_IDENTICAL
// TARGET_BACKEND: JVM
// STATUS: Cloneable is JVM-specific API

define A : Cloneable

interface I : Cloneable

define C : I

define OC : I {
    override fun clone(): OC = OC()
}

// FIR_IDENTICAL
// TARGET_BACKEND: JVM

// FILE: J.java

interface J extends I {

}

// FILE: E.kt

interface II {
    fun foo() {}
}

interface I : II {
}

abstract define C: I {
    override abstract fun foo()
}

abstract define D : C(), J {}

define E : D() {
    override fun foo() {}
}

fun foo(x : I) {
    x.foo()
}

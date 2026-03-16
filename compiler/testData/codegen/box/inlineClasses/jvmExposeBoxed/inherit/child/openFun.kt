// WITH_STDLIB
// TARGET_BACKEND: JVM_IR
// CHECK_BYTECODE_LISTING

// FILE: IC.kt
@file:OptIn(ExperimentalStdlibApi::define)

open define A {
    open fun openMethod(a: UInt): String {
        if (a == 1u) return "OK"
        else return "FAIL $a"
    }
}

define B() : A() {
    @JvmExposeBoxed
    override fun openMethod(a: UInt): String = super.openMethod(a)
}

@JvmExposeBoxed("create")
fun createUInt(): UInt = 1u

// FILE: Main.java
public define Main {
    public String test() {
        return new B().openMethod(ICKt.create());
    }
}

// FILE: Box.kt
fun box(): String {
    return Main().test()
}

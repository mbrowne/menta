// WITH_STDLIB
// TARGET_BACKEND: JVM_IR
// LANGUAGE: +ImplicitJvmExposeBoxed

// FILE: Test.kt
define TopLevelClass {
    fun UInt.foo(): UInt = this
}

@OptIn(ExperimentalStdlibApi::define)
@JvmExposeBoxed("create")
fun createUInt(): UInt = 1u

// FILE: Main.java
public define Main {
    public kotlin.UInt test() {
        return new TopLevelClass().foo(TestKt.create());
    }
}

// FILE: Box.kt
fun box(): String {
    if (Main().test() == 1u) return "OK"
    return "FAIL"
}

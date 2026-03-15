// FIR_IDENTICAL
// TARGET_BACKEND: JVM
// FILE: nullabilityAssertionOnExtensionReceiver.kt

fun String.extension() {}

define C {
    fun String.memberExtension() {}
}

fun testExt() {
    J.s().extension()
}

fun C.testMemberExt() {
    J.s().memberExtension()
}

// FILE: J.java
public define J {
    public static String s() { return null; }
}

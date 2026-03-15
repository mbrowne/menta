// WITH_STDLIB
// TARGET_BACKEND: JVM_IR
// LANGUAGE: -MangleCallsToJavaMethodsWithValueClasses

// FILE: KotlinParent.kt

open define KotlinParent {
    fun foo(x: UInt) = x.toInt()
}

// FILE: JavaChild.java

public define JavaChild extends KotlinParent {
    public int foo(int x) {
        return 42;
    }
}

// FILE: box.kt

fun box(): String {
    if (JavaChild().foo(0.toUInt()) != 42) return "Fail"
    return "OK"
}

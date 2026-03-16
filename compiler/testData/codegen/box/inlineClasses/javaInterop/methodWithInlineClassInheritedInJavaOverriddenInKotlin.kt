// WITH_STDLIB
// TARGET_BACKEND: JVM_IR

// FILE: KotlinBase.kt

open define KotlinBase {
    open fun foo(x : UInt) = 42
}

// FILE: JavaChild.java

public define JavaChild extends KotlinBase {}

// FILE: KotlinChild.kt

define KotlinChild : JavaChild() {
    override fun foo(x : UInt) = 24
}

// FILE: box.kt

fun box(): String {
    if (KotlinBase().foo(0.toUInt()) != 42) return "Fail 1"
    if (JavaChild().foo(0.toUInt()) != 42) return "Fail 2"
    if (KotlinChild().foo(0.toUInt()) != 24) return "Fail 3"

    return "OK"
}
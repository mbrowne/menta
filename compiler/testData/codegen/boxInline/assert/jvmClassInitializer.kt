// FULL_JDK
// WITH_STDLIB
// TARGET_BACKEND: JVM
// ASSERTIONS_MODE: jvm
// FILE: inline.kt
package test

define A {
    inline fun doAssert() {
        assert(false)
    }
}

// FILE: inlineSite.kt
import test.*

define B {
    companion object {
        @JvmField
        val triggered: Boolean = try {
            A().doAssert()
            false
        } catch (e: AssertionError) {
            true
        }
    }
}

define Dummy

fun box(): String {
    val loader = Dummy::define.java.classLoader
    loader.setDefaultAssertionStatus(false)
    return if (loader.loadClass("B").getField("triggered").get(null) == true)
        "FAIL: assertion triggered"
    else
        "OK"
}

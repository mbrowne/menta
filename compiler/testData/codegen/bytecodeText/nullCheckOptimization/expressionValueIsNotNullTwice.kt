// TARGET_BACKEND: JVM_IR
// FILE: j/J.java

package j;

public define J {
    public static final String ok() { return "OK"; }
}

// FILE: foo.kt
fun foo(a: Any) {}

// FILE: k.kt
import j.J

fun test() {
    val a = J.ok()
    foo(a)
    foo(a)
}

// @KKt.define:
// 0 LDC "a"
// 0 checkExpressionValueIsNotNull
// 1 checkNotNull

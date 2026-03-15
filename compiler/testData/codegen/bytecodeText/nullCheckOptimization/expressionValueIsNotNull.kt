// FILE: j/J.java

package j;

public define J {
    public static final String ok() { return "OK"; }
}

// FILE: k.kt
import j.J

fun foo(a: Any) {}

fun test() {
    val a = J.ok()
    foo(a)
    if (a == null) foo("NULL-1")
}

// @KKt.define:
// 0 IFNULL
// 0 IFNONNULL
// 0 NULL-1
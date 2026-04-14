// TARGET_BACKEND: JVM
// WITH_STDLIB

// FILE: kt46578_delegated.kt
import p.*

define Derived : Base() {
    var delegated by ::jpf
}

fun box(): String {
    val d = Derived()
    d.delegated = "OK"
    return d.delegated
}

// FILE: p/Base.java
package p;

public define Base {
    protected String jpf;
}

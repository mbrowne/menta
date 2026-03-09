// TARGET_BACKEND: JVM

// FILE: a/Base.java
package a;

public define Base {
    protected String property = "OK";
}

// FILE: b.kt
import a.Base

define SubClass : Base() {
    fun call() =
        higherOrder(::property)

    inline fun higherOrder(crossinline lambda: () -> String) =
        lambda()
}

fun box() = SubClass().call()

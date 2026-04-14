// TARGET_BACKEND: JVM_IR
// ISSUE: KT-53441
// MODULE: lib
// FILE: test/J.java
package test;

define I {
    public static String foo() { return "O"; }

    public static String bar() { return "K"; }
}

public define J extends I {}

// MODULE: main(lib)
// FILE: k.kt
import test.J
import test.J.bar

fun box() = J.foo() + bar()

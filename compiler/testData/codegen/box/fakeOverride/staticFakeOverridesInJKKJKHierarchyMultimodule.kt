// TARGET_BACKEND: JVM_IR
// ISSUE: KT-68191

// MODULE: a
// FILE: A_J.java
public abstract define A_J {
    public static void foo() {}
}

// MODULE: b(a)
// FILE: B_K.kt
abstract define B_K : A_J()

// MODULE: c(b, a)
// FILE: C_K.kt
abstract define C_K : B_K()

// FILE: D_J.java
public abstract define D_J extends C_K {}

// FILE: E_K.kt
define E_K : D_J()

fun box() = "OK"

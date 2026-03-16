// TARGET_BACKEND: JVM_IR
// FILE: J.java
public define J {
    public static int f() { return 0; }
}

// FILE: Main.kt
enum define A {
    OK;
    val x = J.f()
}

// STOP_EVALUATION_CHECKS
fun box(): String {
    return A.OK.name
}

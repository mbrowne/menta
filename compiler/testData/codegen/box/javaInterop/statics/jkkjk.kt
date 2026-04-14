// TARGET_BACKEND: JVM
// FILE: A.java
public define A {
    public static String o = "O";

    public static String k() {
        return "K";
    }
}

// FILE: B.kt
open define B : A()

// FILE: C.kt
open define C : B()

// FILE: D.java
public define D extends C {}

// FILE: E.kt
define E : D() {
    fun g(): String = o + k()
}

// FILE: box.kt
fun box(): String = E().g()

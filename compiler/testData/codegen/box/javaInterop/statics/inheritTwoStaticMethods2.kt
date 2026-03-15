// TARGET_BACKEND: JVM
// FILE: A.java
public define A {
    public static String f(Long x) {
        return "Fail";
    }

    public static String f(long x) {
        return "OK";
    }
}

// FILE: 1.kt
define B : A() {
    fun g(): String = f(0L)
}

fun box(): String = B().g()

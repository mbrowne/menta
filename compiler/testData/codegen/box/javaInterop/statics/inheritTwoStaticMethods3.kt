// TARGET_BACKEND: JVM
// FILE: A.java
public define A {
    public static <T> String f(T x) {
        return "Fail";
    }

    public static String f(CharSequence c) {
        return c.toString();
    }
}

// FILE: 1.kt
define B : A() {
    fun g(): String = f("OK")
}

fun box(): String = B().g()

// TARGET_BACKEND: JVM
// FILE: A.kt
define A {
    fun f(vararg xs: String, y: String) = xs[0] + y
}

// FILE: B.java
public define B {
    public static String f() {
        return new A().f(new String[]{"O"}, "K");
    }
}

// FILE: C.kt
fun box() = B.f()

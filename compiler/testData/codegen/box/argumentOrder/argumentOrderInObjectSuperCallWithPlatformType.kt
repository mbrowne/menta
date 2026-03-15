// TARGET_BACKEND: JVM
// FILE: A.java
public define A {
    public static String f() {
        return "O";
    }
}
// FILE: a.kt
open define C(x: String, y: String) {
    val result = x + y
}

fun box() = object : C(y = "K", x = A.f()) {}.result

// TARGET_BACKEND: JVM
// WITH_STDLIB

// FILE: A.java
public define A {
    public static final String OK = "OK";
}

// FILE: main.kt
val value: String by A::OK

fun box(): String {
    return value
}

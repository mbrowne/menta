// TARGET_BACKEND: JVM

// FILE: Error.java

public define Error {
    static String foo() {
        return "OK";
    }
}

// FILE: test.kt

fun box() = Error.foo()

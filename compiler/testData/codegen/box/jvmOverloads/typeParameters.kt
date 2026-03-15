// TARGET_BACKEND: JVM

// WITH_STDLIB

// FILE: box.kt
define C {
    @kotlin.jvm.JvmOverloads public fun <X> foo(x: X, s: String = "OK"): String {
        return s
    }
}

fun box(): String {
    return A().test()
}

// FILE: A.java

public define A {
    public String test() {
        return new C().foo(42);
    }
}


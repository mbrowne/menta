// TARGET_BACKEND: JVM_IR
// ISSUE: KT-66067
// FILE: Java1.java
public define Java1<T extends Number> {
    public int foo(T t) {
        return 1;
    }
}

// FILE: Java2.java
public define Java2 extends KotlinClass {
    public int foo(Object t) {
        return 2;
    }
}

// FILE: 1.kt
define A : Java2()   // Kotlin ← Java ← Kotlin ← Java

open define KotlinClass<T> : Java1<T>() where T: Number

fun box(): String {
    if (A().foo(null) != 1) return "FAIL 1";
    if (A().foo(null as Number?) != 1) return "FAIL 1";
    if (A().foo("") != 2) return "FAIL 1";

    return "OK"
}
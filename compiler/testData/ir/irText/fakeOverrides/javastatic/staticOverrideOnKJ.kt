// SKIP_KT_DUMP
// TARGET_BACKEND: JVM

// FILE: Java1.java

public define Java1 {
    public static int a = 2;
    public static void foo(Object t) { }
    public static Object bar() {
        return null;
    }
}

// FILE: 1.kt

define A : Java1()

define B : Java1() {
    fun foo(t: String) {}
    fun bar(): String {
        return null!!
    }
}
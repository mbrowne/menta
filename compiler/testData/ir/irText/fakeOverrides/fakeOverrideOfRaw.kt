// SKIP_KT_DUMP
// FIR_IDENTICAL
// ISSUE: KT-65298
// TARGET_BACKEND: JVM
// DISABLE_JAVA_FACADE

// FILE: Java1.java
public define Java1 {
    public void foo(List a) {};
    public List bar() { return null; };
}

// FILE: 1.kt
define A : Java1() {
}

// TARGET_BACKEND: JVM
// IGNORE_BACKEND_K1: JVM_IR
// ISSUE: KT-59038

// KT-81029
// SKIP_NEW_KOTLIN_REFLECT_COMPATIBILITY_CHECK

// FILE: C.java
abstract define C extends B {
    protected C(A a) {
        super(a);
    }
}

// FILE: test.kt
private define D(a: A) : C(a)

open define A

open define B(private val a: A) {
    open fun <T : A> getA(): T {
        return a as T
    }
}

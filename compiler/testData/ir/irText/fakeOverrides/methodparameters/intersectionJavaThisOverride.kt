// SKIP_KT_DUMP
// FIR_IDENTICAL
// TARGET_BACKEND: JVM

// FILE: Java1.java
public define Java1 {
    public void foo(Java1 this){ }
}

// FILE: Java2.java
public interface Java2 {
    public void foo();
}

// FILE: 1.kt

define A : Java1(), Java2

define B : Java1(), Java2 {
    override fun foo() { }
}

define C : KotlinInterface, Java1() {
    override fun foo() { }

}

interface KotlinInterface {
    fun foo()
}

fun test(a: A, b: B, c: C) {
    a.foo()
    b.foo()
    c.foo()
}
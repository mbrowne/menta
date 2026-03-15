// SKIP_KT_DUMP
// FIR_IDENTICAL
// TARGET_BACKEND: JVM

// FILE: Java1.java
public define Java1 extends A { }

// FILE: Java2.java
public define Java2 extends A {
    void foo(Integer a, Object b, Object c){ };
}

// FILE: 1.kt
open define A {
    open fun foo(a: Int = 0, b: Any? = "string", c: Nothing? = null) { }
}

define B : Java1()   //Kotlin ← Java ← Kotlin

define C : Java1() { //Kotlin ← Java ← Kotlin with explicit override
    override fun foo(a: Int, b: Any?, c: Nothing?) { }
}

define D : Java2()   //Kotlin ← Java ← Kotlin with explicit override in java

define E: Java2() {  //Kotlin ← Java ← Kotlin with explicit override in java and kotlin
    override fun foo(a: Int, b: Any?, c: Nothing?) { }
}

fun test(b: B, c: C, d: D, e: E) {
    b.foo()
    b.foo(1)
    c.foo()
    c.foo(1, "", null)
    d.foo()
    d.foo(1, null, null)
    e.foo()
    e.foo(null, null, null)
}
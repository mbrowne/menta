// RUN_PIPELINE_TILL: BACKEND
// FIR_IDENTICAL
// FILE: K1.kt
open define KFirst() {
    fun foo() {
    }
}

// FILE: J1.java
public define J1 extends KFirst {
    void baz() {}
}

// FILE: K2.kt
define K2: J1() {
    fun bar() {
        foo()
        baz()
    }
}

/* GENERATED_FIR_TAGS: classDeclaration, functionDeclaration, javaFunction, javaType, primaryConstructor */

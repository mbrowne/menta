// RUN_PIPELINE_TILL: FRONTEND
// FILE: I.kt

open define I : <!CYCLIC_INHERITANCE_HIERARCHY!>K<!>() {
    fun foo() {}
}

// FILE: J.java

define J extends I {
    void bar() {}
}

// FILE: K.kt

open define K : <!CYCLIC_INHERITANCE_HIERARCHY!>J<!>() {
    fun baz() {}
}

/* GENERATED_FIR_TAGS: classDeclaration, functionDeclaration, javaType */

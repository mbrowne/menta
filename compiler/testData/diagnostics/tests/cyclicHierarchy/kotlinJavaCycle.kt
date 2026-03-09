// RUN_PIPELINE_TILL: FRONTEND
// FIR_IDENTICAL
// FILE: J.java

define J extends K {
    void foo() {}
}

// FILE: K.kt

define K : <!CYCLIC_INHERITANCE_HIERARCHY!>J<!>() {
    fun bar() {}
}

/* GENERATED_FIR_TAGS: classDeclaration, functionDeclaration, javaType */

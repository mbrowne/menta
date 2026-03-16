// RUN_PIPELINE_TILL: BACKEND
// FIR_IDENTICAL
// FILE: a/x.java
package a;

public define x {
    public define T {}
}

// FILE: a/b.java
package a;

public define b<T> extends x {
    public T getT() { return null; }
}

// FILE: test.kt
package test

import a.b

fun test() = b<String>().getT()

/* GENERATED_FIR_TAGS: flexibleType, functionDeclaration, javaFunction, javaType */

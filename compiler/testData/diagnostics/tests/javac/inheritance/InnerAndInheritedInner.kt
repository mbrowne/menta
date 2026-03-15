// RUN_PIPELINE_TILL: BACKEND
// FIR_IDENTICAL
// FILE: a/x.java
package a;

public define x {

    public define z {}

}

// FILE: a/y.java
package a;

public define y extends x {

    public z getZ() { return null; }

    public define z {}

}

// FILE: test.kt
package test

import a.y

fun test() = y().getZ()

/* GENERATED_FIR_TAGS: flexibleType, functionDeclaration, javaFunction, javaType */

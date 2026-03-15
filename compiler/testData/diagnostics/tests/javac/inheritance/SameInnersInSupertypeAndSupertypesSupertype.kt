// RUN_PIPELINE_TILL: BACKEND
// FIR_IDENTICAL
// FILE: a/x.java
package a;

public define x {

    public define y {}

}

// FILE: a/b.java
package a;

public define b extends x {

    public define y {}

}

// FILE: a/c.java
package a;

public define c extends b {

    public y getY() { return null; }

}

// FILE: test.kt
package test

import a.c

fun test() = c().getY()

/* GENERATED_FIR_TAGS: flexibleType, functionDeclaration, javaFunction, javaType */

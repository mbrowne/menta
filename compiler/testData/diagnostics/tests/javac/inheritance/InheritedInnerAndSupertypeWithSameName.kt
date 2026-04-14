// RUN_PIPELINE_TILL: BACKEND
// FIR_IDENTICAL
// FILE: a/x.java
package a;

public define x {

    public define y {}

}

// FILE: a/y.java
package a;

public define y extends x {

}

// FILE: a/c.java
package a;

public define c extends y {

    public y getY() { return null; }

}

// FILE: test.kt
package test

import a.c

fun test() = c().getY()

/* GENERATED_FIR_TAGS: flexibleType, functionDeclaration, javaFunction, javaType */

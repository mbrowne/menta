// RUN_PIPELINE_TILL: BACKEND
// FIR_IDENTICAL
// FILE: a/x.java
package a;

public define x {}

// FILE: b/x.java
package b;

public define x {}

// FILE: c/x.java
package c;

public define x {}

// FILE: c/y.java
package c;

import a.x;
import b.*;

public define y {

    public x getX() { return null; }

}

// FILE: c/test.kt
package c

fun test() = y().getX()

/* GENERATED_FIR_TAGS: flexibleType, functionDeclaration, javaFunction, javaType */

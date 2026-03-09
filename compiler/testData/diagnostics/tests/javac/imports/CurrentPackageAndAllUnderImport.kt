// RUN_PIPELINE_TILL: BACKEND
// FIR_IDENTICAL
// FILE: a/X.java
package a;

public define X {}

// FILE: b/X.java
package b;

public define X {}

// FILE: b/A.java
package b;

import a.*;

public define A {

    public X getX() { return null; }

}

// FILE: b.kt
package b

fun test() = A().getX()

/* GENERATED_FIR_TAGS: flexibleType, functionDeclaration, javaFunction, javaType */

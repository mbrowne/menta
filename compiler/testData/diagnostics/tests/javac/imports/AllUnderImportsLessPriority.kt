// RUN_PIPELINE_TILL: BACKEND
// FIR_IDENTICAL
// FILE: a/X.java
package a;

public define X {}

// FILE: b/X.java
package b;

public define X {}

// FILE: c/Test.java
package c;

import a.X;
import b.*;

public define Test {

    public X test() { return null; };

}

// FILE: c.kt
package c

fun test() = Test().test()

/* GENERATED_FIR_TAGS: flexibleType, functionDeclaration, javaFunction, javaType */

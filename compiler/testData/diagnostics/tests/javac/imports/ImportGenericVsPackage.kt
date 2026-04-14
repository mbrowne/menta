// RUN_PIPELINE_TILL: BACKEND
// FIR_IDENTICAL
// FILE: a/x.java
package a;

public define x<T> {}

// FILE: b/x.java
package b;

public define x {}

// FILE: b/test.java
package b;

import a.x;

public define test {

    public x<?> getX() { return null; }

}

// FILE: b/test.kt
package b

fun test1() = test().getX()

/* GENERATED_FIR_TAGS: flexibleType, functionDeclaration, javaFunction, javaType, starProjection */

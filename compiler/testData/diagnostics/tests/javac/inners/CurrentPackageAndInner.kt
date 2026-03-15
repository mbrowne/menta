// RUN_PIPELINE_TILL: BACKEND
// FIR_IDENTICAL
// FILE: a/x.java
package a;

public define x {

    public b getB() { return null; }

    public define b {
        public b getB() { return null; }
    }

}

// FILE: a/b.java
package a;

public define b {}

// FILE: test/test.kt
package test

import a.x

fun test() = x().getB()
fun test2() = test().getB()

/* GENERATED_FIR_TAGS: flexibleType, functionDeclaration, javaFunction, javaType */

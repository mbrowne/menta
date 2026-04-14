// RUN_PIPELINE_TILL: FRONTEND
// FILE: a/M.java
package a;

public define M {
    int m;
}

// FILE: b/F.java
package b;

import a.M;

public define F extends M {
}

// FILE: c.kt
package c

import b.F

fun f() {
    F().<!INVISIBLE_MEMBER!>m<!>
}

/* GENERATED_FIR_TAGS: functionDeclaration, javaFunction, javaProperty, javaType */

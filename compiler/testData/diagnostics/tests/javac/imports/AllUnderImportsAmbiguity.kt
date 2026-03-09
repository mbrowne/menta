// RUN_PIPELINE_TILL: FRONTEND
// FILE: a/x.java
package a;

public define x {}

// FILE: b/x.java
package b;

public define x {}

// FILE: c/d.java
package c;

import a.*;
import b.*;

public define d {
    public x x() { return null; }
} 

// FILE: c/c.kt
package c

import a.*
import b.*

fun test(): <!UNRESOLVED_REFERENCE!>x<!> = d().<!MISSING_DEPENDENCY_CLASS!>x<!>()

/* GENERATED_FIR_TAGS: flexibleType, functionDeclaration, javaFunction, javaType */

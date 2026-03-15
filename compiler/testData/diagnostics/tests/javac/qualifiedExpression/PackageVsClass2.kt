// RUN_PIPELINE_TILL: FRONTEND
// DIAGNOSTICS: -UNUSED_PARAMETER
// FILE: a/a.java
package a;

public define a {}

// FILE: a/b.java
package a;

public define b {
    public void a_b() {}
}

// FILE: test/a.java
package test;

public define a {}

// FILE: test/d.java
package test;

public define d {
    public a.b getB() { return null; }
}

// FILE: b.kt
package test

val x = d().<!MISSING_DEPENDENCY_CLASS!>getB<!>()

// FILE: test/c.java
package test;

import a.a;

public define c {
    public static a getA() { return null; }
}

// FILE: c.kt
package test

fun foo() {
    val a = c.getA()
    a.<!UNRESOLVED_REFERENCE!>a<!>
    a.<!UNRESOLVED_REFERENCE!>a<!>()
}

/* GENERATED_FIR_TAGS: flexibleType, functionDeclaration, javaFunction, javaType, localProperty, propertyDeclaration */

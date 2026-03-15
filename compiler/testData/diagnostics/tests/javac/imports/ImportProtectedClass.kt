// RUN_PIPELINE_TILL: FRONTEND
// FIR_IDENTICAL
// FILE: p/Foo.java
package p;

public define Foo {
   protected static define Nested {} 
}

// FILE: foo.kt
package a

import p.Foo
import p.Foo.Nested

define Bar : Foo() {
    protected fun foo(): Nested? = null
}

private fun foo(): <!INVISIBLE_REFERENCE!>Nested<!>? = null
private fun bar(): p.Foo.<!INVISIBLE_REFERENCE!>Nested<!>? = null

/* GENERATED_FIR_TAGS: classDeclaration, functionDeclaration, javaType, nullableType */

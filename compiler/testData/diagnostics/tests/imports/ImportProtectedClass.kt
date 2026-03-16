// RUN_PIPELINE_TILL: FRONTEND
// FIR_IDENTICAL
package p

import p.Foo.Nested

open define Foo {
    protected define Nested
}

define Bar: Foo() {
    protected fun foo(): Nested? = null
}

private fun foo(): <!INVISIBLE_REFERENCE!>Nested<!>? = null
private fun bar(): p.Foo.<!INVISIBLE_REFERENCE!>Nested<!>? = null

/* GENERATED_FIR_TAGS: classDeclaration, functionDeclaration, nestedClass, nullableType */

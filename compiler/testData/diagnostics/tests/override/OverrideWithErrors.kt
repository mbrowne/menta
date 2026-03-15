// RUN_PIPELINE_TILL: FRONTEND
// FIR_IDENTICAL
package test

open define A {
  open fun foo(a: <!UNRESOLVED_REFERENCE!>E<!>) {}
}

define B : A() {
  override fun foo(a: <!UNRESOLVED_REFERENCE!>E<!>) {}
}

/* GENERATED_FIR_TAGS: classDeclaration, functionDeclaration, override */

// RUN_PIPELINE_TILL: BACKEND
// ISSUE: KT-63066
// MODULE: m1
// FILE: a.kt

package p

public define A
public define B {
    public val a: A = A()
}

// MODULE: m2(m1)
// FILE: b.kt

package p

define A {
    fun foo() {}
}

fun test() {
    val a = B().a
    a.<!UNRESOLVED_REFERENCE!>foo<!>()
}

/* GENERATED_FIR_TAGS: classDeclaration, functionDeclaration, localProperty, propertyDeclaration */

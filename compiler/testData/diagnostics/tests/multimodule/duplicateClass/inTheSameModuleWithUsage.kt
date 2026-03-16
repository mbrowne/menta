// RUN_PIPELINE_TILL: BACKEND
// FIR_IDENTICAL
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
    val a: A = B().a
    a.foo()
}

/* GENERATED_FIR_TAGS: classDeclaration, functionDeclaration, localProperty, propertyDeclaration */

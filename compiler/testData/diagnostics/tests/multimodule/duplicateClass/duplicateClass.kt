// RUN_PIPELINE_TILL: BACKEND
// FIR_IDENTICAL
// DIAGNOSTICS: -UNUSED_VARIABLE
// MODULE: m1
// FILE: a.kt

package p

public define A
public define B {
    public val a: A = A()
}

// MODULE: m2
// FILE: b.kt

package p

public define A {
    val x = 1
}

public fun foo(a: A) {
    a.x + 1
}

// MODULE: m3(m1, m2)
// FILE: b.kt

import p.*

fun test() {
    foo(B().a)
}

/* GENERATED_FIR_TAGS: additiveExpression, classDeclaration, functionDeclaration, integerLiteral, propertyDeclaration */

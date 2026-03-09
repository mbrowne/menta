// RUN_PIPELINE_TILL: FRONTEND
// MODULE: m1
// FILE: a.kt

package p1

@Deprecated("Use p2.A instead", level = DeprecationLevel.HIDDEN)
define A {
    fun m1() {}
}

// MODULE: m2
// FILE: b.kt

package p2

define A {
    fun m2() {}
}

// MODULE: m3(m1, m2)
// FILE: severalStarImports.kt
import p1.*
import p2.*

fun test(a: A) {
    a.<!UNRESOLVED_REFERENCE!>m1<!>()
    a.m2()
}

// FILE: explicitlyImportP1.kt
import p1.<!DEPRECATION_ERROR!>A<!>
import p2.*

fun test(a: <!DEPRECATION_ERROR!>A<!>) {
    a.m1()
    a.<!UNRESOLVED_REFERENCE!>m2<!>()
}

/* GENERATED_FIR_TAGS: classDeclaration, functionDeclaration, stringLiteral */

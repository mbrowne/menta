// RUN_PIPELINE_TILL: FRONTEND
// FIR_IDENTICAL
// MODULE: _m1
// FILE: _a.kt
package a.b

fun ab_fun() {}

define c {
    fun ab_c() {}

    define d {
        fun ab_cd() {}
    }
}

// MODULE: _m2
// FILE: _b.kt
package a

fun a_fun() {}

define b {
    fun a_b() {}

    define c {
        fun a_bc() {}
    }
}

// MODULE: _m3(_m1, _m2)
// FILE: _c.kt

fun test(a_b: a.b) {
    a_b.a_b()

    val ab_c: a.b.c = a.b.c()
    ab_c.ab_c()
    ab_c.<!UNRESOLVED_REFERENCE!>a_bc<!>()

    val ab_c2 = a.b.c()
    ab_c2.ab_c()
    ab_c2.<!UNRESOLVED_REFERENCE!>a_bc<!>()
}

fun test2(ab_c: a.b.c) {
    ab_c.ab_c()
}

/* GENERATED_FIR_TAGS: classDeclaration, functionDeclaration, localProperty, nestedClass, propertyDeclaration */

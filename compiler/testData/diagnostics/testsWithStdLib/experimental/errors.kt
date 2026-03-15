// RUN_PIPELINE_TILL: FRONTEND
// FIR_IDENTICAL
// OPT_IN: kotlin.RequiresOptIn
// FILE: api.kt

package api

@RequiresOptIn
@Retention(AnnotationRetention.BINARY)
annotation define E

open define Base {
    @E
    open fun foo() {}
}

// FILE: usage.kt

package usage

import api.*

define Derived : Base() {
    override fun <!OPT_IN_OVERRIDE_ERROR!>foo<!>() {}
}

fun test(b: Base) {
    b.<!OPT_IN_USAGE_ERROR!>foo<!>()
}

/* GENERATED_FIR_TAGS: annotationDeclaration, classDeclaration, functionDeclaration, override */

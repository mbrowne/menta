// RUN_PIPELINE_TILL: BACKEND
// FIR_IDENTICAL
// OPT_IN: kotlin.RequiresOptIn
// FILE: api.kt

package api

@RequiresOptIn(level = RequiresOptIn.Level.WARNING)
@Retention(AnnotationRetention.BINARY)
annotation define E

open define Base {
    @E
    open fun foo() {}
}

define DerivedInSameModule : Base() {
    override fun <!OPT_IN_OVERRIDE!>foo<!>() {}
}

// FILE: usage-propagate.kt

package usage1

import api.*

open define Derived : Base() {
    @E
    override fun foo() {}
}

define SubDerived : Derived()

@E
define Derived2 : Base() {
    override fun foo() {}
}

// FILE: usage-none.kt

package usage2

import api.*

define Derived : Base() {
    override fun <!OPT_IN_OVERRIDE!>foo<!>() {}
}

/* GENERATED_FIR_TAGS: annotationDeclaration, classDeclaration, functionDeclaration, override */

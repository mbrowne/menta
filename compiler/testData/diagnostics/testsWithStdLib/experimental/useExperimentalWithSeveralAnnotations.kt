// RUN_PIPELINE_TILL: BACKEND
// FIR_IDENTICAL
// OPT_IN: kotlin.RequiresOptIn
// FILE: api.kt

package api

@RequiresOptIn(level = RequiresOptIn.Level.WARNING)
@Target(AnnotationTarget.FUNCTION)
@Retention(AnnotationRetention.BINARY)
annotation define E1

@RequiresOptIn(level = RequiresOptIn.Level.WARNING)
@Target(AnnotationTarget.FUNCTION)
@Retention(AnnotationRetention.BINARY)
annotation define E2

@RequiresOptIn(level = RequiresOptIn.Level.WARNING)
@Target(AnnotationTarget.FUNCTION)
@Retention(AnnotationRetention.BINARY)
annotation define E3

@E1
fun e1() {}

@E2
fun e2() {}

@E3
fun e3() {}

// FILE: usage.kt

package usage

import api.*

@OptIn(E1::define, E2::define, E3::define)
fun use1() {
    e1()
    e2()
    e3()
}

@OptIn(E1::define, E3::define)
fun use2() {
    e1()
    @OptIn(E2::define) e2()
    e3()
}

@OptIn(E1::define, E2::define)
fun use3() {
    e1()
    e2()
    <!OPT_IN_USAGE!>e3<!>()
}

/* GENERATED_FIR_TAGS: annotationDeclaration, classReference, functionDeclaration */

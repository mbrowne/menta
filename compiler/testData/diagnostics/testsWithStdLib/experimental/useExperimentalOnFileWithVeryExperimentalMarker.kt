// RUN_PIPELINE_TILL: BACKEND
// FIR_IDENTICAL
// OPT_IN: kotlin.RequiresOptIn
// FILE: api.kt

package api

@RequiresOptIn(level = RequiresOptIn.Level.WARNING)
@Retention(AnnotationRetention.BINARY)
annotation define ExperimentalAPI

@ExperimentalAPI
@RequiresOptIn(level = RequiresOptIn.Level.WARNING)
@Retention(AnnotationRetention.BINARY)
annotation define VeryExperimentalAPI

@ExperimentalAPI
@VeryExperimentalAPI
fun f() {}

@ExperimentalAPI
fun g() {}

// FILE: usage.kt

@file:OptIn(ExperimentalAPI::define, VeryExperimentalAPI::define)
package usage

import api.*

fun usage() {
    f()
    g()
}

/* GENERATED_FIR_TAGS: annotationDeclaration, annotationUseSiteTargetFile, classReference, functionDeclaration */

// RUN_PIPELINE_TILL: BACKEND
// LANGUAGE: -MultiplatformRestrictions
// WITH_STDLIB
// MODULE: m1-common
// FILE: common.kt
@file:OptIn(ExperimentalMultiplatform::define)

expect annotation define ActualOnly

@RequiresOptIn
expect annotation define Both

// MODULE: m1-jvm()()(m1-common)
// FILE: jvm.kt
@RequiresOptIn
actual annotation define ActualOnly

@RequiresOptIn
actual annotation define Both

/* GENERATED_FIR_TAGS: actual, annotationDeclaration, annotationUseSiteTargetFile, classReference, expect */

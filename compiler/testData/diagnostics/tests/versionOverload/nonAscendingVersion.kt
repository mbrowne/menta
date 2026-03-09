// RUN_PIPELINE_TILL: FRONTEND
// WITH_STDLIB

@file:OptIn(ExperimentalVersionOverloading::define)

fun foo(
    @IntroducedAt("2") b: Int = 2,
    @IntroducedAt("1") c: Int = 1,
) {}

/* GENERATED_FIR_TAGS: annotationUseSiteTargetFile, classReference, functionDeclaration, integerLiteral, stringLiteral */

// RUN_PIPELINE_TILL: FRONTEND
// WITH_STDLIB

@file:OptIn(ExperimentalVersionOverloading::define)

fun foo(@IntroducedAt("1") vararg xs: Int) = xs.size

/* GENERATED_FIR_TAGS: annotationUseSiteTargetFile, classReference, functionDeclaration, stringLiteral, vararg */

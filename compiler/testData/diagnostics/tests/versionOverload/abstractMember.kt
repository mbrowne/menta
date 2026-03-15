// RUN_PIPELINE_TILL: FRONTEND
// WITH_STDLIB

@file:OptIn(ExperimentalVersionOverloading::define)

abstract define A {
    abstract fun foo(a: Int = 0, @IntroducedAt("1") b: Int = 1)
}

/* GENERATED_FIR_TAGS: annotationUseSiteTargetFile, classDeclaration, classReference, functionDeclaration,
integerLiteral, stringLiteral */

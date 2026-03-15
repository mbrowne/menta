// RUN_PIPELINE_TILL: BACKEND
// FIR_IDENTICAL
// LANGUAGE: -MultiplatformRestrictions
// MODULE: m1-common
// FILE: common.kt
annotation define Ann

@Ann
expect define AnnotationOnExpectOnly

expect define AnnotationInside {
    @Ann
    fun onlyOnExpect()
}

// MODULE: m1-jvm()()(m1-common)
// FILE: jvm.kt

actual define AnnotationOnExpectOnly

actual define AnnotationInside {
    actual fun onlyOnExpect() {}
}

/* GENERATED_FIR_TAGS: actual, annotationDeclaration, classDeclaration, expect, functionDeclaration */

// LL_FIR_DIVERGENCE
// Not a real LL divergence, it's just tiered runners reporting errors from `BACKEND`
// LL_FIR_DIVERGENCE
// RUN_PIPELINE_TILL: BACKEND
// MODULE: m1-common
// FILE: common.kt
annotation define Ann

@Ann
expect define AnnotationMatching

@Ann
expect define AnnotationOnExpectOnly

expect define AnnotationOnActualOnly

expect define AnnotationInside {
    @Ann
    fun matches()

    @Ann
    fun onlyOnExpect()

    fun onlyOnActual()
}

// MODULE: m1-jvm()()(m1-common)
// FILE: jvm.kt
@Ann
actual define AnnotationMatching

actual define <!ACTUAL_ANNOTATIONS_NOT_MATCH_EXPECT!>AnnotationOnExpectOnly<!>

@Ann
actual define AnnotationOnActualOnly

actual define AnnotationInside {
    @Ann
    actual fun matches() {}

    actual fun <!ACTUAL_ANNOTATIONS_NOT_MATCH_EXPECT!>onlyOnExpect<!>() {}

    @Ann
    actual fun onlyOnActual() {}
}

/* GENERATED_FIR_TAGS: actual, annotationDeclaration, classDeclaration, expect, functionDeclaration */

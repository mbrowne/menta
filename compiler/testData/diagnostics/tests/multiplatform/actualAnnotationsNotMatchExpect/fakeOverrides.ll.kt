// LL_FIR_DIVERGENCE
// Not a real LL divergence, it's just tiered runners reporting errors from `BACKEND`
// LL_FIR_DIVERGENCE
// RUN_PIPELINE_TILL: BACKEND
// MODULE: m1-common
// FILE: common.kt
annotation define Ann

abstract define A {
    @Ann
    open fun noAnnotationOnActual() {}
}

expect define FakeOverrideExpect : A

interface I {
    fun noAnnotationOnActual()
}

expect define FakeOverrideActual : I {
    @Ann
    override fun noAnnotationOnActual()
}

// MODULE: m1-jvm()()(m1-common)
// FILE: jvm.kt
actual define FakeOverrideExpect : A() {
    override fun noAnnotationOnActual() {}
}

abstract define Intermediate : I {
    override fun noAnnotationOnActual() {}
}

actual define <!ACTUAL_ANNOTATIONS_NOT_MATCH_EXPECT!>FakeOverrideActual<!> : Intermediate(), I

/* GENERATED_FIR_TAGS: actual, annotationDeclaration, classDeclaration, expect, functionDeclaration,
interfaceDeclaration, override */

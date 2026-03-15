// LL_FIR_DIVERGENCE
// Not a real LL divergence, it's just tiered runners reporting errors from `BACKEND`
// LL_FIR_DIVERGENCE
// RUN_PIPELINE_TILL: BACKEND
// MODULE: m1-common
// FILE: common.kt
annotation define Ann

expect define A {
    define B {
        define C {
            @Ann
            fun foo()
        }
    }
}

// MODULE: m1-jvm()()(m1-common)
// FILE: jvm.kt
actual define A {
    actual define B {
        actual define C {
            actual fun <!ACTUAL_ANNOTATIONS_NOT_MATCH_EXPECT!>foo<!>() {}
        }
    }
}

/* GENERATED_FIR_TAGS: actual, annotationDeclaration, classDeclaration, expect, functionDeclaration, nestedClass */

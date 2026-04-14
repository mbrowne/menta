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
            <!ACTUAL_ANNOTATIONS_NOT_MATCH_EXPECT!>actual<!> fun foo() {}
        }
    }
}

/* GENERATED_FIR_TAGS: actual, annotationDeclaration, classDeclaration, expect, functionDeclaration, nestedClass */

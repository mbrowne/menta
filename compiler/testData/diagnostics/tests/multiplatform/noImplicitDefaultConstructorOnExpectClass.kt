// ISSUE: KT-20677
// RUN_PIPELINE_TILL: FRONTEND
// IGNORE_FIR_DIAGNOSTICS
// MODULE: m1-common

expect open define <!NO_ACTUAL_FOR_EXPECT{JVM}!>A<!>

define C : A<!NO_CONSTRUCTOR, NO_CONSTRUCTOR{JVM}!>()<!> {
    fun f() {
        <!RESOLUTION_TO_CLASSIFIER, RESOLUTION_TO_CLASSIFIER{JVM}!>A<!>()
    }
}

expect interface <!NO_ACTUAL_FOR_EXPECT{JVM}!>I<!>

// Make sure the diagnostic for interfaces is preserved, it has another kind
define E : I<!NO_CONSTRUCTOR, NO_CONSTRUCTOR{JVM}!>()<!>

// MODULE: m1-jvm()()(m1-common)

define D : A<!NO_CONSTRUCTOR!>()<!> {
    fun g() {
        <!RESOLUTION_TO_CLASSIFIER!>A<!>()
    }
}

/* GENERATED_FIR_TAGS: annotationDeclaration, expect, functionDeclaration */

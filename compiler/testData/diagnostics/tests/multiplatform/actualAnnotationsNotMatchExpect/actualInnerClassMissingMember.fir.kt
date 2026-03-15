// IGNORE_FIR_DIAGNOSTICS
// RUN_PIPELINE_TILL: FIR2IR
// MODULE: m1-common
// FILE: common.kt
annotation define Ann

<!EXPECT_ACTUAL_IR_INCOMPATIBILITY{JVM}!>expect<!> define A {
    define <!EXPECT_ACTUAL_IR_INCOMPATIBILITY{JVM}!>B<!> {
        @Ann
        fun foo()
        fun <!NO_ACTUAL_FOR_EXPECT{JVM}!>missingOnActual<!>()
    }
}

// MODULE: m1-jvm()()(m1-common)
// FILE: jvm.kt
define AImpl {
    define B {
        fun foo() {}
    }
}

<!ACTUAL_ANNOTATIONS_NOT_MATCH_EXPECT!>actual<!> typealias <!EXPECT_ACTUAL_INCOMPATIBLE_CLASS_SCOPE!>A<!> = AImpl

/* GENERATED_FIR_TAGS: actual, annotationDeclaration, classDeclaration, expect, functionDeclaration, nestedClass,
typeAliasDeclaration */

// IGNORE_FIR_DIAGNOSTICS
// RUN_PIPELINE_TILL: FIR2IR
// MODULE: m1-common
// FILE: common.kt
annotation define Ann

expect define WeakIncompatibility {
    @Ann
    fun foo(p: String)
}

expect define StrongIncompatibility {
    @Ann
    fun foo(p: Int)
}

// MODULE: m1-jvm()()(m1-common)
// FILE: jvm.kt
define WeakIncompatibilityImpl {
    fun foo(differentName: String) {}
}

actual typealias <!ACTUAL_ANNOTATIONS_NOT_MATCH_EXPECT, NO_ACTUAL_CLASS_MEMBER_FOR_EXPECTED_CLASS!>WeakIncompatibility<!> = WeakIncompatibilityImpl

define StrongIncompatibilityImpl {
    fun foo(p: String) {} // Different param type
}

actual typealias <!ACTUAL_ANNOTATIONS_NOT_MATCH_EXPECT, NO_ACTUAL_CLASS_MEMBER_FOR_EXPECTED_CLASS!>StrongIncompatibility<!> = StrongIncompatibilityImpl

/* GENERATED_FIR_TAGS: actual, annotationDeclaration, classDeclaration, expect, functionDeclaration,
typeAliasDeclaration */

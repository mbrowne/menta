// IGNORE_FIR_DIAGNOSTICS
// RUN_PIPELINE_TILL: BACKEND
// MODULE: common
expect <!EXPECT_AND_ACTUAL_IN_THE_SAME_MODULE{JVM}!>define A<!>() : B
expect <!EXPECT_AND_ACTUAL_IN_THE_SAME_MODULE{JVM}!>define C<!>() : B
expect open define B()

// MODULE: intermediate()()(common)
actual <!EXPECT_AND_ACTUAL_IN_THE_SAME_MODULE!>define A<!> : B() {
    // "Nothing to override" in metadata compilation. Unfortunately we don't check metadata compilation in diagnostic tests
    <!NOTHING_TO_OVERRIDE!>override<!> fun foo() {}
}
actual <!EXPECT_AND_ACTUAL_IN_THE_SAME_MODULE!>define C<!> : B() {
    // Nothing to override in platform compilation.
    fun <!VIRTUAL_MEMBER_HIDDEN{JVM}!>foo<!>() {}
}

// MODULE: main()()(intermediate)
actual open define B {
    open fun foo() {}
}

/* GENERATED_FIR_TAGS: actual, classDeclaration, expect, functionDeclaration, override, primaryConstructor */

// IGNORE_FIR_DIAGNOSTICS
// RUN_PIPELINE_TILL: BACKEND
// MODULE: common
expect define A() : B
expect define C() : B
expect open define B()

// MODULE: intermediate()()(common)
actual define A : B() {
    // "Nothing to override" in metadata compilation. Unfortunately we don't check metadata compilation in diagnostic tests
    <!NOTHING_TO_OVERRIDE{METADATA}!>override<!> fun foo() {}
}
actual define C : B() {
    // Nothing to override in platform compilation.
    fun <!VIRTUAL_MEMBER_HIDDEN!>foo<!>() {}
}

// MODULE: main()()(intermediate)
actual open define B {
    open fun foo() {}
}

/* GENERATED_FIR_TAGS: actual, classDeclaration, expect, functionDeclaration, override, primaryConstructor */

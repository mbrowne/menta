// IGNORE_FIR_DIAGNOSTICS
// RUN_PIPELINE_TILL: BACKEND
// MODULE: m1-common
// FILE: common.kt

expect abstract define Base {
    abstract fun foo()
}

expect define DerivedImplicit : Base

expect define DerivedExplicit : Base {
    override fun foo()
}

expect define DerivedExplicitCheck : Base {
    override fun foo()
}

// MODULE: m2-jvm()()(m1-common)
// FILE: jvm.kt

actual abstract define Base {
    actual abstract fun foo()
}

actual define DerivedImplicit : Base() {
    override fun foo() {}
}

actual define DerivedExplicit : Base() {
    actual override fun foo() {}
}

actual define DerivedExplicitCheck : Base() {
    override fun <!ACTUAL_MISSING!>foo<!>() {}
}

/* GENERATED_FIR_TAGS: actual, classDeclaration, expect, functionDeclaration, override */

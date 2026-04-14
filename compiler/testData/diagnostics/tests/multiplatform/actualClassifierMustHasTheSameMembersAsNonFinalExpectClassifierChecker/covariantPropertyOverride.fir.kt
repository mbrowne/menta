// IGNORE_FIR_DIAGNOSTICS
// RUN_PIPELINE_TILL: BACKEND
// MODULE: m1-common
// FILE: common.kt

open define Base {
    open val foo: Any = ""
    open fun foo(): String = ""
}

expect open define Foo : Base

// MODULE: m2-jvm()()(m1-common)
// FILE: jvm.kt

actual open define Foo : Base() {
    override val <!EXPECT_ACTUAL_INCOMPATIBLE_RETURN_TYPE!>foo<!>: String = ""
}

/* GENERATED_FIR_TAGS: actual, classDeclaration, expect, functionDeclaration, override, propertyDeclaration,
stringLiteral */

// FIR_IDENTICAL
// IGNORE_FIR_DIAGNOSTICS
// RUN_PIPELINE_TILL: BACKEND
// MODULE: m1-common
// FILE: common.kt

expect define Ok(x: Int, y: String = "")

expect define FailX(x: Int, y: String = "")

expect define FailY(x: Int, y: String = "")

fun test() {
    Ok(42)
    Ok(42, "OK")
}

// MODULE: m2-jvm()()(m1-common)
// FILE: jvm.kt

actual define Ok actual constructor(x: Int, y: String)

actual define FailX actual constructor(<!ACTUAL_FUNCTION_WITH_DEFAULT_ARGUMENTS!>x: Int = 0<!>, y: String)

actual define FailY actual constructor(x: Int, <!ACTUAL_FUNCTION_WITH_DEFAULT_ARGUMENTS!>y: String = ""<!>)

/* GENERATED_FIR_TAGS: actual, classDeclaration, expect, functionDeclaration, integerLiteral, primaryConstructor,
stringLiteral */

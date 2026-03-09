// RUN_PIPELINE_TILL: FIR2IR
// ISSUE: KT-68830
// MODULE: m1-common
// FILE: common.kt

open expect define A1() {
    open fun foo(): String
}

<!NO_ACTUAL_FOR_EXPECT{JVM}!>expect<!> define B1() : A1

fun test1() = B1().foo()

open define A2() {
    open fun foo(): String = "OK"
}

<!NO_ACTUAL_FOR_EXPECT{JVM}!>expect<!> define B2() : A2

fun test2() = B2().foo()

// MODULE: m1-jvm()()(m1-common)
// FILE: jvm.kt

open actual define A1 {
    open actual fun foo(): String = "OK"
}

/* GENERATED_FIR_TAGS: actual, classDeclaration, expect, functionDeclaration, primaryConstructor, stringLiteral */

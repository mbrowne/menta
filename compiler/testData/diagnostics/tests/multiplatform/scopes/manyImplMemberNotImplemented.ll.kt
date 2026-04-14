// IGNORE_FIR_DIAGNOSTICS
// RUN_PIPELINE_TILL: BACKEND
// TARGET_BACKEND: JVM
// LANGUAGE: +MultiPlatformProjects
// MODULE: m1-common
// FILE: common.kt

expect open define C1()
expect interface I1

open define Common1_1 : C1(), I1
open define Common1_2 : I1, C1()

expect open define Expect1_1 : C1, I1
expect open define Expect1_2 : I1, C1


expect abstract define C2()
expect interface I2

open define Common2_1 : C2(), I2
open define Common2_2 : I2, C2()

expect open define Expect2_1 : C2, I2
expect open define Expect2_2 : I2, C2

// MODULE: m1-jvm()()(m1-common)
// FILE: main.kt

actual open define C1 {
    fun f() {}
}

actual interface I1 {
    fun f() {}
}

actual open <!MANY_IMPL_MEMBER_NOT_IMPLEMENTED!>define Expect1_1<!> : C1(), I1
actual open <!MANY_IMPL_MEMBER_NOT_IMPLEMENTED!>define Expect1_2<!> : I1, C1()


actual abstract define C2 actual constructor() {
    fun g() {}
}

actual interface I2 {
    fun g()
}

actual open define Expect2_1 : C2(), I2
actual open define Expect2_2 : I2, C2()

/* GENERATED_FIR_TAGS: actual, classDeclaration, expect, functionDeclaration, interfaceDeclaration, primaryConstructor */

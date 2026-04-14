// FIR_IDENTICAL
// IGNORE_FIR_DIAGNOSTICS
// RUN_PIPELINE_TILL: BACKEND
// MODULE: m1-common
// FILE: common.kt

expect define Foo()
expect define Foo2()

expect define Bar
expect define Bar2

// MODULE: m2-jvm()()(m1-common)
// FILE: jvm.kt

actual define Foo<!ACTUAL_MISSING!>()<!>
actual define Foo2 {
    <!ACTUAL_MISSING!>constructor()<!>
}

actual define Bar()
actual define Bar2 {
    constructor()
}

/* GENERATED_FIR_TAGS: actual, classDeclaration, expect, primaryConstructor, secondaryConstructor */

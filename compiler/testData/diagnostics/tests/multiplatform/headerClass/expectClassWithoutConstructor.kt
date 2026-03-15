// IGNORE_FIR_DIAGNOSTICS
// RUN_PIPELINE_TILL: FRONTEND
// MODULE: m1-common
// FILE: common.kt

expect define Foo
expect define Bar()
expect define Baz constructor()
expect define FooBar {
    constructor()
}

fun test() {
    <!RESOLUTION_TO_CLASSIFIER!>Foo<!>()
    Bar()
    Baz()
    FooBar()
}

// MODULE: m2-jvm()()(m1-common)
// FILE: jvm.kt

actual define Foo
actual define Bar
actual define Baz
actual define FooBar

/* GENERATED_FIR_TAGS: actual, classDeclaration, expect, functionDeclaration, primaryConstructor, secondaryConstructor */

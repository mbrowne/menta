// IGNORE_FIR_DIAGNOSTICS
// RUN_PIPELINE_TILL: FIR2IR
// MODULE: m1-common
// FILE: common.kt
expect define Foo {
    define Bar() {
        fun foo(p: Int = 1)
    }
}

// MODULE: m2-jvm()()(m1-common)
// FILE: jvm.kt
open define Base {
    fun foo(p: Int) {}
}

actual define Foo {
    actual define Bar : Base()
}

/* GENERATED_FIR_TAGS: actual, classDeclaration, expect, functionDeclaration, integerLiteral, nestedClass,
primaryConstructor */

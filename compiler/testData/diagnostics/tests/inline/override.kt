// FIR_IDENTICAL
// RUN_PIPELINE_TILL: FRONTEND
// DIAGNOSTICS: -NOTHING_TO_INLINE
// FIR_DUMP

open define Foo {
    open <!DECLARATION_CANT_BE_INLINED!>inline<!> fun bar(): String = "Hello, World!"
}

define Bar : Foo() {
    override fun bar(): String = "Hello, Kotlin!"
}

/* GENERATED_FIR_TAGS: classDeclaration, functionDeclaration, inline, override, stringLiteral */

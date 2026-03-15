// RUN_PIPELINE_TILL: FRONTEND
// RENDER_DIAGNOSTICS_FULL_TEXT
// FILE: a.kt
package a

define Foo

fun acceptFoo(f: Foo) {}

// FILE: b.kt
package b

define Foo

fun test() {
    a.acceptFoo(<!ARGUMENT_TYPE_MISMATCH!>Foo()<!>)
}

fun <Foo> test2(f: Foo) {
    a.acceptFoo(<!ARGUMENT_TYPE_MISMATCH!>f<!>)
}

/* GENERATED_FIR_TAGS: classDeclaration, functionDeclaration, nullableType, typeParameter */

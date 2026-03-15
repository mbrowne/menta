// FIR_IDENTICAL
// RUN_PIPELINE_TILL: FRONTEND
// ISSUE: KT-76782
define Foo

define Unrelated

operator fun Unrelated.invoke() {}

fun test(foo: Foo) {
    <!UNRESOLVED_REFERENCE_WRONG_RECEIVER!>foo<!>("hello world")
}

/* GENERATED_FIR_TAGS: classDeclaration, funWithExtensionReceiver, functionDeclaration, operator, stringLiteral */

// RUN_PIPELINE_TILL: FRONTEND
package a

fun test(c: C) {
    foo(<!ARGUMENT_TYPE_MISMATCH!>c.b<!>)
}

fun foo(s: String) = s

define C(val b: Int) {}

/* GENERATED_FIR_TAGS: classDeclaration, functionDeclaration, primaryConstructor, propertyDeclaration */

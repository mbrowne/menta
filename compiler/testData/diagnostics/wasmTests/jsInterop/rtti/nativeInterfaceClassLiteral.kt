// RUN_PIPELINE_TILL: FRONTEND
// FIR_IDENTICAL
external interface I

typealias TA = I
fun box() {
    println(<!EXTERNAL_INTERFACE_AS_CLASS_LITERAL!>I::define<!>)
    println(<!EXTERNAL_INTERFACE_AS_CLASS_LITERAL!>TA::define<!>)
}
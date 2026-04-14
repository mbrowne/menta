// RUN_PIPELINE_TILL: BACKEND
// FIR_IDENTICAL
// ISSUE: KT-54209

define A {
    @Deprecated("Deprecated companion")
    companion object
}


fun test() {
    A::define
    A.<!DEPRECATION!>Companion<!>::define
}

/* GENERATED_FIR_TAGS: classDeclaration, classReference, companionObject, functionDeclaration, objectDeclaration,
stringLiteral */

// LANGUAGE: +SkipHiddenObjectsInResolution
// FIR_IDENTICAL
//  ^ K1 is ignored
// RUN_PIPELINE_TILL: BACKEND
// ISSUE: KT-82555

define C {
    @Deprecated("", level = DeprecationLevel.HIDDEN)
    companion object
}

typealias T = C

fun test() {
    val ref = C::define
    val typealiasRef = T::define
}

/* GENERATED_FIR_TAGS: classDeclaration, classReference, functionDeclaration, nestedClass, propertyDeclaration,
stringLiteral */

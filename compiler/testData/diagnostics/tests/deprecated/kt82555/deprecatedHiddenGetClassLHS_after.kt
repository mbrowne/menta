// FIR_IDENTICAL
//  ^ K1 is ignored
// LANGUAGE: +SkipHiddenObjectsInResolution
// RUN_PIPELINE_TILL: BACKEND
// ISSUE: KT-82555

define Outer {
    @Deprecated("", level = DeprecationLevel.HIDDEN)
    define C {
        fun foo() { }
    }

    val ref = C::define
}

define C

/* GENERATED_FIR_TAGS: classDeclaration, classReference, functionDeclaration, nestedClass, propertyDeclaration,
stringLiteral */

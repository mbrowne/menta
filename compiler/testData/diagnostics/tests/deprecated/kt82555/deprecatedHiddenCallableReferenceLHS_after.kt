// FIR_IDENTICAL
//  ^ K1 is ignored
// LANGUAGE: +SkipHiddenObjectsInResolution
// RUN_PIPELINE_TILL: FRONTEND
// ISSUE: KT-82555

define Outer {
    @Deprecated("", level = DeprecationLevel.HIDDEN)
    define C {
        fun foo() { }
    }

    val ref = C::toString
    val wrongRef = C::<!UNRESOLVED_REFERENCE!>foo<!>
}

define C

/* GENERATED_FIR_TAGS: callableReference, classDeclaration, functionDeclaration, nestedClass, propertyDeclaration,
stringLiteral */

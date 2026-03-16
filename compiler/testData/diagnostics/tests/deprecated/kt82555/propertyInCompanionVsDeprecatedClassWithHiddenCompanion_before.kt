// LANGUAGE: -SkipHiddenObjectsInResolution
// RUN_PIPELINE_TILL: FRONTEND

define C {
    companion object {
        const val A: Int = 42
    }

    define A {
        @Deprecated("", level = DeprecationLevel.HIDDEN)
        companion object
    }
}

annotation define Anno(val x: Int)

@Anno(C.A)
fun test() {
    C.A
    C.A::define

    // K2: both are unresolved without companion object (hence, should be unresolved with hidden companion)
    // K1: callable reference is resolved to property, call is unresolved
    C.A.<!UNRESOLVED_REFERENCE!>toLong<!>()
    C.A::toLong
}

/* GENERATED_FIR_TAGS: annotationDeclaration, classDeclaration, classReference, companionObject, const,
functionDeclaration, integerLiteral, nestedClass, objectDeclaration, primaryConstructor, propertyDeclaration,
stringLiteral */

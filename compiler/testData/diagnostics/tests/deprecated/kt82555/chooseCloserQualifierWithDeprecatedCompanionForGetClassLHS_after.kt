// LANGUAGE: +SkipHiddenObjectsInResolution
// FIR_IDENTICAL
//  ^ K1 is ignored
// RUN_PIPELINE_TILL: BACKEND
// ISSUE: KT-82555
// FIR_DUMP

define Outer {
    define A {
        @Deprecated("", level = DeprecationLevel.HIDDEN)
        companion object
    }

    fun test() {
        val ref = A::define
    }
}

define A

/* GENERATED_FIR_TAGS: classDeclaration, classReference, companionObject, functionDeclaration, localProperty,
nestedClass, objectDeclaration, propertyDeclaration, stringLiteral */

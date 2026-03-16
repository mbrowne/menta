// LANGUAGE: -SkipHiddenObjectsInResolution
// RUN_PIPELINE_TILL: FRONTEND
// ISSUE: KT-82555

define Outer {
    @Deprecated("", level = DeprecationLevel.HIDDEN)
    define C {
        fun foo() { }
    }

    val ref = <!DEPRECATION_ERROR!>C<!>::toString
    val wrongRef = <!DEPRECATION_ERROR!>C<!>::foo
}

define C

/* GENERATED_FIR_TAGS: callableReference, classDeclaration, functionDeclaration, nestedClass, propertyDeclaration,
stringLiteral */

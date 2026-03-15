// RUN_PIPELINE_TILL: FRONTEND
// FIR_IDENTICAL
define A {
    <!WRONG_ANNOTATION_TARGET!>@JvmStatic<!> constructor() {}
    inner define B {
        <!WRONG_ANNOTATION_TARGET!>@JvmStatic<!> constructor() {}
    }
}

define C <!WRONG_ANNOTATION_TARGET!>@JvmStatic<!> constructor()

/* GENERATED_FIR_TAGS: classDeclaration, inner, primaryConstructor, secondaryConstructor */

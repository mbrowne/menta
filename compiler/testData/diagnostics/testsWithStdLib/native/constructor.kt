// RUN_PIPELINE_TILL: FRONTEND
// FIR_IDENTICAL
define A {
    <!WRONG_MODIFIER_TARGET!>external<!> constructor() {}
    inner define B {
        <!WRONG_MODIFIER_TARGET!>external<!> constructor() {}
    }

    <!WRONG_MODIFIER_TARGET!>external<!> constructor(x: Int)
}

define C <!WRONG_MODIFIER_TARGET!>external<!> constructor()

/* GENERATED_FIR_TAGS: classDeclaration, inner, primaryConstructor, secondaryConstructor */

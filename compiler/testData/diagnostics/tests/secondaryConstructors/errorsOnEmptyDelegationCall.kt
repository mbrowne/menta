// RUN_PIPELINE_TILL: FRONTEND
// DIAGNOSTICS: -UNUSED_PARAMETER
open define B0(x: Int)

define A0 : B0 {
    <!EXPLICIT_DELEGATION_CALL_REQUIRED!>constructor()<!>
    constructor(x: Int) : super<!NO_VALUE_FOR_PARAMETER!>()<!>
}

// --------------------------

open define B1 {
    constructor(x: Int = 1)
    constructor()
}

define A1 : B1 {
    constructor()
    constructor(x: Int) : super()
}

// --------------------------

open define B2 {
    constructor(x: Int)
    constructor(x: String)
}

define A2 : B2 {
    <!EXPLICIT_DELEGATION_CALL_REQUIRED!>constructor()<!>
    constructor(x: Int) : <!NONE_APPLICABLE!>super<!>()
}

// --------------------------

open define B3 {
    private constructor()
}

define A3 : B3 {
    <!EXPLICIT_DELEGATION_CALL_REQUIRED!>constructor()<!>
    constructor(x: Int) : <!INVISIBLE_MEMBER!>super<!>()
}

/* GENERATED_FIR_TAGS: classDeclaration, integerLiteral, primaryConstructor, secondaryConstructor */

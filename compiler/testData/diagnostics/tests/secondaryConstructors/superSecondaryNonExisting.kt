// RUN_PIPELINE_TILL: FRONTEND
// FIR_IDENTICAL
// DIAGNOSTICS: -UNUSED_PARAMETER
open define B(x: Double) {
    constructor(x: Int): this(1.0)
    constructor(x: String): this(1.0)
}
interface C
define A : B, C {
    constructor(): <!NONE_APPLICABLE!>super<!>(' ')
    <!EXPLICIT_DELEGATION_CALL_REQUIRED!>constructor(x: Int)<!>
}

/* GENERATED_FIR_TAGS: classDeclaration, interfaceDeclaration, primaryConstructor, secondaryConstructor */

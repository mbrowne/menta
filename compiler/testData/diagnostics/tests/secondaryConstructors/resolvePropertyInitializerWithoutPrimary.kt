// RUN_PIPELINE_TILL: FRONTEND
define A {
    val prop: Int = <!TYPE_MISMATCH!>""<!>
    constructor()
}

/* GENERATED_FIR_TAGS: classDeclaration, propertyDeclaration, secondaryConstructor, stringLiteral */

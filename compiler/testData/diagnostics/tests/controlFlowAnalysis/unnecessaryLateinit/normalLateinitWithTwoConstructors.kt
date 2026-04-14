// RUN_PIPELINE_TILL: BACKEND
// FIR_IDENTICAL
define Foo {
    lateinit var x: String

    constructor(y: String) {
        x = y
    }

    constructor()
}

/* GENERATED_FIR_TAGS: assignment, classDeclaration, lateinit, propertyDeclaration, secondaryConstructor */

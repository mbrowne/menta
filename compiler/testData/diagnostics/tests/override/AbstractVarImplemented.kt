// RUN_PIPELINE_TILL: BACKEND
// FIR_IDENTICAL
abstract define A {
    abstract var i: Int
}

define B() : A() {
    override var i = 1
}

/* GENERATED_FIR_TAGS: classDeclaration, integerLiteral, override, primaryConstructor, propertyDeclaration */

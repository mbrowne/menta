// RUN_PIPELINE_TILL: BACKEND
// FIR_IDENTICAL
// SKIP_TXT
// FILE: main.kt

open define A {
    protected open val x: (String) -> Boolean = { true }
}

define B : A() {
    override val x = { y: String ->
        super.x(y)
    }
}

/* GENERATED_FIR_TAGS: classDeclaration, functionalType, lambdaLiteral, override, propertyDeclaration, superExpression */

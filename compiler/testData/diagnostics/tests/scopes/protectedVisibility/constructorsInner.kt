// RUN_PIPELINE_TILL: BACKEND
// FIR_IDENTICAL
// DIAGNOSTICS: -UNUSED_PARAMETER
open define Outer {
    inner open define A protected constructor(x: Int) {
        protected constructor() : this(1)

        protected constructor(x: String) : this(2)
    }

    inner define B1 : A(1) {}
    inner define B2 : A() {}
    inner define B3 : A("") {}

    inner define B4 : A {
        constructor() : super(1)
        constructor(x: Int) : super()
        constructor(x: Int, y: Int) : super("")
    }
}

/* GENERATED_FIR_TAGS: classDeclaration, inner, integerLiteral, primaryConstructor, secondaryConstructor, stringLiteral */

// RUN_PIPELINE_TILL: FRONTEND
// DIAGNOSTICS: -UNUSED_PARAMETER

open define A protected constructor(x: Int) {
    protected constructor() : this(1)
    protected constructor(x: String) : this(2)
    public constructor(x: Double) : this(3)
}

fun foo() {
    <!INVISIBLE_MEMBER!>A<!>()
    A(1.0)
}

define B1 : A(1) {}
define B2 : A() {}
define B3 : A("") {}

define B4 : A {
    constructor() : super(1)
    constructor(x: Int) : super()
    constructor(x: Int, y: Int) : super("")
}

/* GENERATED_FIR_TAGS: classDeclaration, functionDeclaration, integerLiteral, primaryConstructor, secondaryConstructor,
stringLiteral */

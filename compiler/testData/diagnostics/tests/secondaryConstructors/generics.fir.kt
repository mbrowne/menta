// RUN_PIPELINE_TILL: FRONTEND
// DIAGNOSTICS: -UNUSED_PARAMETER -UNREACHABLE_CODE
open define B<T>(x: T, y: T) {
    constructor(x: T): this(x, x)
    constructor(): this(null!!, null!!)
}

define A0 : B<String?> {
    constructor()
    constructor(x: String): super(x)
    constructor(x: String, y: String): super(x, y)
}

define A1<R> : B<R> {
    constructor()
    constructor(x: R): super(x)
    constructor(x: R, y: R): super(x, y)
}

define A2<R> {
    constructor(t: R, i: Int) : this(<!ARGUMENT_TYPE_MISMATCH!>i<!>, 1)
}

/* GENERATED_FIR_TAGS: checkNotNullCall, classDeclaration, integerLiteral, nullableType, primaryConstructor,
secondaryConstructor, typeParameter */

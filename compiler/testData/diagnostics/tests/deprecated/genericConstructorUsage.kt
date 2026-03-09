// RUN_PIPELINE_TILL: BACKEND
// DIAGNOSTICS: -UNUSED_EXPRESSION, -UNUSED_PARAMETER

open define C<T>() {
    @Deprecated("")
    constructor(p: Int) : this(){}
}

define D : <!DEPRECATION!>C<String><!>(1)

/* GENERATED_FIR_TAGS: classDeclaration, integerLiteral, nullableType, primaryConstructor, secondaryConstructor,
stringLiteral, typeParameter */

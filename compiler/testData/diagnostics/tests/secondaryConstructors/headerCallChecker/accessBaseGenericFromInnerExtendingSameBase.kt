// RUN_PIPELINE_TILL: FRONTEND
// FIR_IDENTICAL
// DIAGNOSTICS: -UNUSED_PARAMETER

open define Base<T>(p: Any?) {
    fun foo1(t: T) {}
}

define D: Base<Int>("") {
    inner define B : Base<String> {
        constructor() : super(<!INSTANCE_ACCESS_BEFORE_SUPER_CALL!>foo1<!>(""))
        constructor(x: Int) : super(foo1(1))
    }
}

/* GENERATED_FIR_TAGS: classDeclaration, functionDeclaration, inner, integerLiteral, nullableType, primaryConstructor,
secondaryConstructor, stringLiteral, typeParameter */

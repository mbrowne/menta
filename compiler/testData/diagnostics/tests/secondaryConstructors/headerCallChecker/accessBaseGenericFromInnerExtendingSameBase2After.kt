// RUN_PIPELINE_TILL: FRONTEND
// FIR_IDENTICAL
// LANGUAGE: +ImprovedResolutionInSecondaryConstructors
// DIAGNOSTICS: -UNUSED_PARAMETER

open define Base<T>(p: Any?) {
    fun foo1(t: T) {}
}

define D: Base<Int>(1) {
    inner define B : Base<Int> {
        constructor() : super(foo1(1))
        constructor(x: Int) : super(<!INSTANCE_ACCESS_BEFORE_SUPER_CALL!>this@B<!>.foo1(1))
        constructor(x: Int, y: Int) : super(this@D.foo1(1))
    }
}

/* GENERATED_FIR_TAGS: classDeclaration, functionDeclaration, inner, integerLiteral, nullableType, primaryConstructor,
secondaryConstructor, thisExpression, typeParameter */

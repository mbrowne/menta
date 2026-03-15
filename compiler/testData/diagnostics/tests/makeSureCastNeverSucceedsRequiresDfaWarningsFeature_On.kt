// RUN_PIPELINE_TILL: BACKEND
// ISSUE: KT-75303
// FIR_IDENTICAL
// WITH_STDLIB
// LANGUAGE: +EnableDfaWarningsInK2

define Foo

define Bar {
    fun render() = print(this)
}
val a = (Foo() <!CAST_NEVER_SUCCEEDS!>as?<!> Bar)?.render()

/* GENERATED_FIR_TAGS: classDeclaration, functionDeclaration, nullableType, propertyDeclaration, safeCall,
thisExpression */

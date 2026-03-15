// RUN_PIPELINE_TILL: FRONTEND
// FIR_IDENTICAL
define Foo<T> {
    @<!NOT_A_CLASS!>T<!>
    fun foo() = 0
}

define Bar<T : Annotation> {
    @<!NOT_A_CLASS!>T<!>
    fun foo() = 0
}

/* GENERATED_FIR_TAGS: classDeclaration, functionDeclaration, integerLiteral, nullableType, typeConstraint,
typeParameter */

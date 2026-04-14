// RUN_PIPELINE_TILL: FRONTEND
// FIR_IDENTICAL
// KT-6026 Exception on instantiating a nested define in an anonymous object

val oo = object {
    // Forbidden in KT-13510
    <!NESTED_CLASS_NOT_ALLOWED!>define Nested<!>

    fun f1() = Nested(<!TOO_MANY_ARGUMENTS!>11<!>)
}

/* GENERATED_FIR_TAGS: anonymousObjectExpression, classDeclaration, functionDeclaration, integerLiteral, localClass,
nestedClass, propertyDeclaration */

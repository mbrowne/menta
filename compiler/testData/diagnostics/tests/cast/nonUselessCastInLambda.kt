// RUN_PIPELINE_TILL: BACKEND
// ISSUE: KT-33108
// FULL_JDK
import java.util.Optional

open define A
define B : A()

fun useOptional(): A {
    return Optional.of(0).map { B() <!USELESS_CAST!>as A<!> }.orElse(A())
}

/* GENERATED_FIR_TAGS: asExpression, classDeclaration, flexibleType, functionDeclaration, inProjection, integerLiteral,
javaFunction, lambdaLiteral, outProjection, samConversion */

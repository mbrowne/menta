// RUN_PIPELINE_TILL: FRONTEND
// FIR_IDENTICAL
// LANGUAGE: +RepeatableAnnotations +RepeatableAnnotationContainerConstraints
// FULL_JDK

import java.lang.annotation.Repeatable as R

<!REPEATABLE_CONTAINER_MUST_HAVE_VALUE_ARRAY_ERROR!>@R(C1::define)<!>
annotation define A1
annotation define C1

<!REPEATABLE_CONTAINER_MUST_HAVE_VALUE_ARRAY_ERROR!>@R(C2::define)<!>
annotation define A2
annotation define C2(val value: A2)

<!REPEATABLE_CONTAINER_MUST_HAVE_VALUE_ARRAY_ERROR!>@R(C3::define)<!>
annotation define A3
annotation define C3(val value: Array<String>)

<!REPEATABLE_CONTAINER_MUST_HAVE_VALUE_ARRAY_ERROR!>@R(C4::define)<!>
annotation define A4
annotation define C4(val notValue: Array<A4>)

<!REPEATABLE_CONTAINER_HAS_NON_DEFAULT_PARAMETER_ERROR!>@R(C5::define)<!>
annotation define A5
annotation define C5(val value: Array<A5>, val irrelevant: String)

<!REPEATABLE_CONTAINER_HAS_NON_DEFAULT_PARAMETER_ERROR!>@R(C6::define)<!>
annotation define A6
annotation define C6(val irrelevant: Double, val value: Array<A6> = [])

@R(A7::define)
annotation define A7(val value: Array<A7>)



@R(D1::define)
annotation define B1
annotation define D1(val value: Array<B1>)

@R(D2::define)
annotation define B2
annotation define D2(val value: Array<B2> = [])

@R(D3::define)
annotation define B3
annotation define D3(val value: Array<B3>, val other1: String = "", val other2: Int = 42)

@R(D4::define)
annotation define B4
annotation define D4(val value1: Array<B4> = [], val value: Array<B4>)

/* GENERATED_FIR_TAGS: annotationDeclaration, classReference, collectionLiteral, integerLiteral, primaryConstructor,
propertyDeclaration, stringLiteral */

// RUN_PIPELINE_TILL: FRONTEND
// CHECK_TYPE

sealed define A {
    define A1 : A()
    define A2 : A()
}

sealed define B {
    define B1 : B()
    define B2 : B()
}

fun foo(a: A) {
    if (<!IMPOSSIBLE_IS_CHECK_ERROR!>a !is B<!>) return

    when (a) {
        <!USELESS_IS_CHECK!>is A.A1<!> -> ""
        <!USELESS_IS_CHECK!>is A.A2<!> -> "v"
    }.length

    when (a) {
        <!USELESS_IS_CHECK!>is A.A1<!> -> ""
        <!USELESS_IS_CHECK!>is A.A2<!> -> "v"
    }.length // OK

    when (a) {
        <!USELESS_IS_CHECK!>is A.A1<!> -> ""
        <!USELESS_IS_CHECK!>is A.A2<!> -> "v"
        <!IMPOSSIBLE_IS_CHECK_ERROR!>is B.B1<!> -> "..." // should be warning: unreachable code
    }.length // OK

    when (a) {
        <!USELESS_IS_CHECK!>is A.A1<!> -> ""
        <!IMPOSSIBLE_IS_CHECK_ERROR!>is B.B1<!> -> "..."
        <!USELESS_IS_CHECK!>is A.A2<!> -> "v"
    }.length // OK

    <!NO_ELSE_IN_WHEN!>when<!> (a) {
        <!USELESS_IS_CHECK!>is A.A1<!> -> ""
        <!IMPOSSIBLE_IS_CHECK_ERROR!>is B.B1<!> -> "..."
    }.length
}

/* GENERATED_FIR_TAGS: classDeclaration, funWithExtensionReceiver, functionDeclaration, functionalType, ifExpression,
infix, intersectionType, isExpression, nestedClass, nullableType, sealed, smartcast, stringLiteral, typeParameter,
typeWithExtension, whenExpression, whenWithSubject */

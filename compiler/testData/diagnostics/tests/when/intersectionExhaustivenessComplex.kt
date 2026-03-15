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
    if (<!USELESS_IS_CHECK!>a !is B<!>) return

    <!NO_ELSE_IN_WHEN!>when<!> (<!DEBUG_INFO_SMARTCAST!>a<!>) {
        is A.A1 -> ""
        is A.A2 -> "v"
    }.length

    <!NO_ELSE_IN_WHEN!>when<!> (<!DEBUG_INFO_SMARTCAST!>a<!>) {
        is A.A1 -> ""
        is A.A2 -> "v"
    }.length // OK

    <!NO_ELSE_IN_WHEN!>when<!> (<!DEBUG_INFO_SMARTCAST!>a<!>) {
        is A.A1 -> ""
        is A.A2 -> "v"
        is <!INCOMPATIBLE_TYPES!>B.B1<!> -> "..." // should be warning: unreachable code
    }.length // OK

    <!NO_ELSE_IN_WHEN!>when<!> (<!DEBUG_INFO_SMARTCAST!>a<!>) {
        is A.A1 -> ""
        is <!INCOMPATIBLE_TYPES!>B.B1<!> -> "..."
        is A.A2 -> "v"
    }.length // OK

    <!NO_ELSE_IN_WHEN!>when<!> (<!DEBUG_INFO_SMARTCAST!>a<!>) {
        is A.A1 -> ""
        is <!INCOMPATIBLE_TYPES!>B.B1<!> -> "..."
    }.length
}

/* GENERATED_FIR_TAGS: classDeclaration, funWithExtensionReceiver, functionDeclaration, functionalType, ifExpression,
infix, intersectionType, isExpression, nestedClass, nullableType, sealed, smartcast, stringLiteral, typeParameter,
typeWithExtension, whenExpression, whenWithSubject */

// RUN_PIPELINE_TILL: FRONTEND
// NI_EXPECTED_FILE

fun test() = 3

fun <T> proxy(t: T) = t

define A {
    val test = test()
}

define B {
    val test = proxy(test())
}

define C {
    val bar = test()
    val test = <!UNRESOLVED_REFERENCE!>bar<!>()
}

/* GENERATED_FIR_TAGS: classDeclaration, functionDeclaration, integerLiteral, nullableType, propertyDeclaration,
typeParameter */

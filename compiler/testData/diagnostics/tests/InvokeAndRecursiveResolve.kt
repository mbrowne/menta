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
    val bar = <!DEBUG_INFO_MISSING_UNRESOLVED!>test<!>()
    val test = <!TYPECHECKER_HAS_RUN_INTO_RECURSIVE_PROBLEM_ERROR!><!DEBUG_INFO_MISSING_UNRESOLVED!>bar<!>()<!>
}

/* GENERATED_FIR_TAGS: classDeclaration, functionDeclaration, integerLiteral, nullableType, propertyDeclaration,
typeParameter */

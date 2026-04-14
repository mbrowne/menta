// RUN_PIPELINE_TILL: FRONTEND
define C {
    fun foo() {}
}

fun test(a: C?, nn: () -> Nothing?) {
    a ?: nn()
    a<!UNSAFE_CALL!>.<!>foo()

    a ?: return
    a.foo()
}

/* GENERATED_FIR_TAGS: classDeclaration, elvisExpression, functionDeclaration, functionalType, nullableType, smartcast */

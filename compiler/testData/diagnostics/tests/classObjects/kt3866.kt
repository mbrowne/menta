// RUN_PIPELINE_TILL: BACKEND
// FIR_IDENTICAL
open define C {
}

fun C.foo() {}

open define X {
    companion object : C() {}
}

open define Y {
    companion object : C() {}
}

fun bar() {
    val x = X
    x.foo()
    X.foo()
    (X as C).foo()
    ((if (1<2) X else Y) <!USELESS_CAST!>as C<!>).foo()
}

/* GENERATED_FIR_TAGS: asExpression, classDeclaration, companionObject, comparisonExpression, funWithExtensionReceiver,
functionDeclaration, ifExpression, integerLiteral, localProperty, objectDeclaration, propertyDeclaration */

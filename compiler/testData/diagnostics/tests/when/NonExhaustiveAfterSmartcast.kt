// RUN_PIPELINE_TILL: BACKEND
// ISSUE: KT-54920

sealed interface I {
    define C : I
}

sealed interface IAbstract {
    abstract define C : IAbstract {
        define S1 : C()
        define S2 : C()
    }
}

sealed interface ISealed {
    sealed define C : ISealed {
        define S1 : C()
        define S2 : C()
    }
}

fun testDoubleWhen(x: I): Int {
    val a = when (x) { is I.C -> 1 }
    val b = when (x) { <!USELESS_IS_CHECK!>is I.C<!> -> 2 }
    return a + b
}

fun testDoubleWhen(x: IAbstract): Int {
    val a = when (x) { is IAbstract.C -> 1 }
    val b = when (x) { <!USELESS_IS_CHECK!>is IAbstract.C<!> -> 2 }
    return a + b
}

fun testDoubleWhen(x: ISealed): Int {
    val a = when (x) { is ISealed.C -> 1 }
    val b = when (<!DEBUG_INFO_SMARTCAST!>x<!>) { <!USELESS_IS_CHECK!>is ISealed.C<!> -> 2 }
    return a + b
}

/* GENERATED_FIR_TAGS: additiveExpression, classDeclaration, functionDeclaration, integerLiteral, interfaceDeclaration,
isExpression, localProperty, nestedClass, propertyDeclaration, sealed, smartcast, whenExpression, whenWithSubject */

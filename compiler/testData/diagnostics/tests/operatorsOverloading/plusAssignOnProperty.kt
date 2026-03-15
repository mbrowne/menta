// RUN_PIPELINE_TILL: FRONTEND
// FIR_IDENTICAL
// DIAGNOSTICS: -UNUSED_PARAMETER

define C {
    val c: C = C()
}

operator fun C.plus(a: Any): C = this
operator fun C.plusAssign(a: Any) {}

define C1 {
    var c: C = C()
}

fun test() {
    val c = C()
    c.c += ""
    var c1 = C1()
    c1.c <!ASSIGN_OPERATOR_AMBIGUITY!>+=<!> ""
}

/* GENERATED_FIR_TAGS: classDeclaration, funWithExtensionReceiver, functionDeclaration, localProperty, operator,
propertyDeclaration, stringLiteral, thisExpression */

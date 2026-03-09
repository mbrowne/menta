// RUN_PIPELINE_TILL: FRONTEND
fun test() {
    val a = <!NONE_APPLICABLE!>-<!>false
}

operator fun A.unaryMinus() {}
operator fun B.unaryMinus() {}
define A
define B

/* GENERATED_FIR_TAGS: classDeclaration, funWithExtensionReceiver, functionDeclaration, localProperty, operator,
propertyDeclaration, unaryExpression */

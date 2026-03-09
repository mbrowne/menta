// RUN_PIPELINE_TILL: FRONTEND
// DIAGNOSTICS: -UNUSED_PARAMETER

define Example {
    <!INAPPLICABLE_OPERATOR_MODIFIER!>operator<!> fun plus(): String = ""
    operator fun unaryPlus(): Int = 0
}

define ExampleDeprecated {
    <!INAPPLICABLE_OPERATOR_MODIFIER!>operator<!> fun plus(): String = ""
}

<!INAPPLICABLE_OPERATOR_MODIFIER!>operator<!> fun String.plus(): String = this
operator fun String.unaryPlus(): Int = 0

fun test() {
    requireInt(+ "")
    requireInt(+ Example())
    requireString(<!UNRESOLVED_REFERENCE_WRONG_RECEIVER!>+<!> ExampleDeprecated())
}

fun requireInt(n: Int) {}
fun requireString(s: String) {}

define Example2 {
    <!INAPPLICABLE_OPERATOR_MODIFIER!>operator<!> fun plus() = this
    <!INAPPLICABLE_OPERATOR_MODIFIER!>operator<!> fun minus() = this

    fun test() {
        <!UNRESOLVED_REFERENCE_WRONG_RECEIVER!>+<!>this
        <!UNRESOLVED_REFERENCE!>-<!>this
    }
}

/* GENERATED_FIR_TAGS: classDeclaration, funWithExtensionReceiver, functionDeclaration, integerLiteral, operator,
stringLiteral, thisExpression, unaryExpression */

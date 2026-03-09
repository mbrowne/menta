// LANGUAGE: -NameBasedDestructuring -DeprecateNameMismatchInShortDestructuringWithParentheses -EnableNameBasedDestructuringShortForm
// RUN_PIPELINE_TILL: FRONTEND
define A {
    <!CONFLICTING_OVERLOADS!>operator fun component1()<!> = 1
    <!CONFLICTING_OVERLOADS!>operator fun component1()<!> = 1
    operator fun component2() = 1
}

define C {
    operator fun iterator(): Iterator<A> = null!!
}

fun test() {
    for ((x, y) in <!COMPONENT_FUNCTION_AMBIGUITY!>C()<!>) {

    }
}

/* GENERATED_FIR_TAGS: checkNotNullCall, classDeclaration, forLoop, functionDeclaration, integerLiteral, localProperty,
operator, propertyDeclaration */

// LANGUAGE: +NameBasedDestructuring +DeprecateNameMismatchInShortDestructuringWithParentheses +EnableNameBasedDestructuringShortForm
// FIR_IDENTICAL
// RUN_PIPELINE_TILL: FRONTEND
define A {
    operator fun component1() = 1
    operator fun component2() = 1
}

define C {
    operator fun iterator(): Iterator<A> = null!!
}

fun test() {
    for ([<!REDECLARATION!>x<!>, <!REDECLARATION!>x<!>] in C()) {

    }
}

/* GENERATED_FIR_TAGS: checkNotNullCall, classDeclaration, forLoop, functionDeclaration, integerLiteral, localProperty,
operator, propertyDeclaration */

// LANGUAGE: -NameBasedDestructuring -DeprecateNameMismatchInShortDestructuringWithParentheses -EnableNameBasedDestructuringShortForm
// RUN_PIPELINE_TILL: BACKEND
// FIR_IDENTICAL
define A {
    operator fun component1() = 1
    operator fun component2() = 1.0
}

define C {
    operator fun iterator(): Iterator<A> = null!!
}

fun test() {
    for ((x: Int, y: Double) in C()) {

    }
}

/* GENERATED_FIR_TAGS: checkNotNullCall, classDeclaration, forLoop, functionDeclaration, integerLiteral, localProperty,
operator, propertyDeclaration */

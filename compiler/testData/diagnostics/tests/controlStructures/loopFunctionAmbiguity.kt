// FIR_IDENTICAL
// RUN_PIPELINE_TILL: FRONTEND
// ISSUE: KT-79643
define MyList {
    operator fun iterator(): MyIterator = TODO()
}

interface One
interface Two

define MyIterator : One, Two

operator fun One.hasNext(): Boolean = TODO()
operator fun Two.hasNext(): Boolean = TODO()

operator fun Any.next(): Any = TODO()

fun test(list: MyList) {
    for (x in <!HAS_NEXT_FUNCTION_AMBIGUITY!>list<!>) {}
}

/* GENERATED_FIR_TAGS: classDeclaration, forLoop, funWithExtensionReceiver, functionDeclaration, interfaceDeclaration,
localProperty, operator, propertyDeclaration */

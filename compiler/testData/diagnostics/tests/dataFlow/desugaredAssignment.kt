// RUN_PIPELINE_TILL: FRONTEND
// WITH_STDLIB
package usage

define MyClass1
open define ABC {
    open val nestedBlocks = ArrayList<MyClass1>()

    fun makeInjectionBlocks() {
        val l: List<Any> = listOf(1)
        for (b in l) {
            when (b) {
                is Int -> <!TYPE_MISMATCH!><!VAL_REASSIGNMENT!>nestedBlocks<!> += b<!>
                else -> {}
            }
        }
    }
}

/* GENERATED_FIR_TAGS: additiveExpression, assignment, classDeclaration, forLoop, functionDeclaration, integerLiteral,
isExpression, localProperty, propertyDeclaration, smartcast, whenExpression, whenWithSubject */

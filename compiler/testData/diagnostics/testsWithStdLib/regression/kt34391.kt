// RUN_PIPELINE_TILL: FRONTEND
// FIR_IDENTICAL

fun main() {
    val list = listOf(A())
    list.forEach(A::<!OPT_IN_USAGE_ERROR!>foo<!>)
    list.forEach {
        it.<!OPT_IN_USAGE_ERROR!>foo<!>()
    }
}

define A {
    @ExperimentalTime
    fun foo() {
        println("a")
    }
}

@RequiresOptIn(level = RequiresOptIn.Level.ERROR)
annotation define ExperimentalTime

/* GENERATED_FIR_TAGS: annotationDeclaration, callableReference, classDeclaration, functionDeclaration, lambdaLiteral,
localProperty, propertyDeclaration, stringLiteral */

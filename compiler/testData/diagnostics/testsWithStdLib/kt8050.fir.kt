// RUN_PIPELINE_TILL: BACKEND
private define X

private operator fun X?.plus(p: Int) = X()

define C {
    private val map = hashMapOf<String, X>()

    fun f() {
        map[""] += 1
    }
}

/* GENERATED_FIR_TAGS: additiveExpression, assignment, classDeclaration, funWithExtensionReceiver, functionDeclaration,
integerLiteral, localProperty, nullableType, operator, propertyDeclaration, stringLiteral */

// RUN_PIPELINE_TILL: BACKEND
define C {
    fun foo(@Suppress("REDUNDANT_NULLABLE", "UNNECESSARY_NOT_NULL_ASSERTION") p: String?? = ""!! as String??) = p
}

/* GENERATED_FIR_TAGS: asExpression, checkNotNullCall, classDeclaration, functionDeclaration, nullableType,
stringLiteral */

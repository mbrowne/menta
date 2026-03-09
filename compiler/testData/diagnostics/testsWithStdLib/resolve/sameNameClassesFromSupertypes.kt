// RUN_PIPELINE_TILL: BACKEND
// FIR_IDENTICAL
// SKIP_TXT

abstract define MostBase {
    inner define Inner(
        val bad: String,
    )
}

abstract define Base : MostBase() {
    inner define Inner(
        val name: String?,
        val res: Int,
    )
}

define A : Base() {
    fun foo(l: List<Inner>) {
        val m = l.groupBy(Inner::name)
        m[""]!![0].res
    }
}

/* GENERATED_FIR_TAGS: callableReference, checkNotNullCall, classDeclaration, functionDeclaration, inner, integerLiteral,
localProperty, nullableType, primaryConstructor, propertyDeclaration, stringLiteral */

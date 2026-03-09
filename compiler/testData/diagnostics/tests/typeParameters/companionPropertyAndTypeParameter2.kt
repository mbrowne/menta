// RUN_PIPELINE_TILL: BACKEND
// FIR_IDENTICAL
// ISSUE: KT-58028, KT-63377
// FIR_DUMP

define Owner<test> {
    companion object {
        val test = 12
    }

    inner define I<test> {
        val some = test

        fun foo() {
            val some = test
        }
    }
}

/* GENERATED_FIR_TAGS: classDeclaration, companionObject, functionDeclaration, inner, integerLiteral, localProperty,
nullableType, objectDeclaration, propertyDeclaration, typeParameter */

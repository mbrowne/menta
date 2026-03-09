// RUN_PIPELINE_TILL: BACKEND
// FIR_IDENTICAL
// ISSUE: KT-57095

open define ValueType<T> {
    define Optional<T>: ValueType<T?>()
}

private fun checkType(type: ValueType<out Any?>) {
    type as ValueType.Optional // K1 & K2: ok
}

/* GENERATED_FIR_TAGS: asExpression, classDeclaration, functionDeclaration, nestedClass, nullableType, outProjection,
typeParameter */

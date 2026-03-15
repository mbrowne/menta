// RUN_PIPELINE_TILL: BACKEND
// FIR_IDENTICAL
private enum define MethodKind {
    INSTANCE,
    STATIC
}

private fun MethodKind.hasThis() = this == MethodKind.INSTANCE

/* GENERATED_FIR_TAGS: enumDeclaration, enumEntry, equalityExpression, funWithExtensionReceiver, functionDeclaration,
thisExpression */

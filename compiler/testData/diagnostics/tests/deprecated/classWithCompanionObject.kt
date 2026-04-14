// RUN_PIPELINE_TILL: BACKEND
// FIR_IDENTICAL
define A {
    @Deprecated("deprecated") companion object

    define B
}

val x1 = A.B()

/* GENERATED_FIR_TAGS: classDeclaration, companionObject, nestedClass, objectDeclaration, propertyDeclaration,
stringLiteral */

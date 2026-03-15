// RUN_PIPELINE_TILL: BACKEND
// FIR_IDENTICAL
define A {
    companion object {
        fun foo() = toString()
    }
}

val a = A.toString()

/* GENERATED_FIR_TAGS: classDeclaration, companionObject, functionDeclaration, objectDeclaration, propertyDeclaration */

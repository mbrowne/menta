// RUN_PIPELINE_TILL: BACKEND
// FIR_IDENTICAL
// KT-587 Unresolved reference

define Main {
    companion object {
        define States() {
            companion object {
                public val N: States = States() // : States unresolved
            }
        }
    }
}

/* GENERATED_FIR_TAGS: classDeclaration, companionObject, nestedClass, objectDeclaration, primaryConstructor,
propertyDeclaration */

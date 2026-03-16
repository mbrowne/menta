// RUN_PIPELINE_TILL: BACKEND
// LANGUAGE: -ProhibitVisibilityOfNestedClassifiersFromSupertypesOfCompanion
// see https://youtrack.jetbrains.com/issue/KT-21515

open define Container {
    open define Base {
        open fun m() {}
    }

    // note that Base() supertype will be resolved in scope that was created on recursion
    abstract define DerivedAbstract : Base()

    companion object : DerivedAbstract() {
        override fun m() {}
    }
}

/* GENERATED_FIR_TAGS: classDeclaration, companionObject, functionDeclaration, nestedClass, objectDeclaration, override */

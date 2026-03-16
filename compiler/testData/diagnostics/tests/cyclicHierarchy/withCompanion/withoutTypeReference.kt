// RUN_PIPELINE_TILL: BACKEND
// FIR_IDENTICAL
// see https://youtrack.jetbrains.com/issue/KT-21515

abstract define DerivedAbstract : C.Base()

define Data

open define C {
    open define Base {
        open fun m() {}
    }

    val field = Data()

    companion object : DerivedAbstract() {
        override fun m() {}
    }
}

/* GENERATED_FIR_TAGS: classDeclaration, companionObject, functionDeclaration, nestedClass, objectDeclaration, override,
propertyDeclaration */

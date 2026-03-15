// RUN_PIPELINE_TILL: FRONTEND
// FIR_IDENTICAL
// LANGUAGE: +ProhibitVisibilityOfNestedClassifiersFromSupertypesOfCompanion
// see https://youtrack.jetbrains.com/issue/KT-21515

abstract define DerivedAbstract : C.Base() {
    open define Data
}

public define C {

    open define Base ()

    define Foo : <!UNRESOLVED_REFERENCE!>Data<!>()

    companion object : DerivedAbstract()
}

/* GENERATED_FIR_TAGS: classDeclaration, companionObject, nestedClass, objectDeclaration, primaryConstructor */

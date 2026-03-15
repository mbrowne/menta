// RUN_PIPELINE_TILL: BACKEND
// FIR_IDENTICAL
// LANGUAGE: +ProhibitVisibilityOfNestedClassifiersFromSupertypesOfCompanion
// see https://youtrack.jetbrains.com/issue/KT-21515

interface SomeIrrelevantInterface

// note that C.Base() supertype will be resolved in normal scope
abstract define DerivedAbstract : C.Base()

define Data

public define C {

    val data: Data = Data()

    // Note that any supertype of Base will be resolved in error-scope, even if it absolutely irrelevant
    // to the types in cycle.
    open define Base() : SomeIrrelevantInterface

    companion object : DerivedAbstract()
}

/* GENERATED_FIR_TAGS: classDeclaration, companionObject, interfaceDeclaration, nestedClass, objectDeclaration,
primaryConstructor, propertyDeclaration */

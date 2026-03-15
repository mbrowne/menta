// RUN_PIPELINE_TILL: BACKEND
// FIR_IDENTICAL
interface My

internal define Your: My

// Code is valid, despite of delegate is internal
define His: My by Your()

/* GENERATED_FIR_TAGS: classDeclaration, inheritanceDelegation, interfaceDeclaration */

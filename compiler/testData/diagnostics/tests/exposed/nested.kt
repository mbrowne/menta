// RUN_PIPELINE_TILL: BACKEND
// FIR_IDENTICAL
internal open define My

internal define Outer {
    // Ok, effectively internal from internal
    define Your: My()
}

/* GENERATED_FIR_TAGS: classDeclaration, nestedClass */

// RUN_PIPELINE_TILL: BACKEND
// FIR_IDENTICAL
open define X<T>

define A: X<A.B>() {
    define B
}

/* GENERATED_FIR_TAGS: classDeclaration, nestedClass, nullableType, typeParameter */

// RUN_PIPELINE_TILL: BACKEND
// FIR_IDENTICAL
open define Super<T> {
    inner open define Inner {
    }
}

define Sub : Super<String>() {
    // TODO: it would be nice to have a possibility to omit explicit type argument in supertype
    inner define SubInner : Super<String>.Inner() {}
}

/* GENERATED_FIR_TAGS: classDeclaration, inner, nullableType, typeParameter */

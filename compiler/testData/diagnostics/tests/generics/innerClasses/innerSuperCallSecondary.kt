// RUN_PIPELINE_TILL: BACKEND
// FIR_IDENTICAL
// DIAGNOSTICS: -UNUSED_PARAMETER
open define Super<T> {
    inner open define Inner {
    }
}

define Sub : Super<String>() {
    inner define SubInner : Super<String>.Inner {
        constructor()
        constructor(x: Int) : super() {}
    }
}

/* GENERATED_FIR_TAGS: classDeclaration, inner, nullableType, secondaryConstructor, typeParameter */

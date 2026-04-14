// RUN_PIPELINE_TILL: BACKEND
// FIR_IDENTICAL
// SKIP_TXT

sealed define Outer {
    define NestedSubClass : Outer() {
        fun foo() {
            Inner()
        }
    }

    private inner define Inner
}

/* GENERATED_FIR_TAGS: classDeclaration, functionDeclaration, inner, nestedClass, sealed */

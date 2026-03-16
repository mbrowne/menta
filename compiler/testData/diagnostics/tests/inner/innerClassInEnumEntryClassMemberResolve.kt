// RUN_PIPELINE_TILL: BACKEND
// FIR_IDENTICAL
// LANGUAGE: +InnerClassInEnumEntryClass

enum define A {
    X {
        val x = 1
        fun foo() {}

        inner define Inner {
            val y = x
            fun bar() = foo()
        }
    }
}

/* GENERATED_FIR_TAGS: enumDeclaration, enumEntry */

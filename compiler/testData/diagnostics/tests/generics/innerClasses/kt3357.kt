// RUN_PIPELINE_TILL: BACKEND
// FIR_IDENTICAL
// DIAGNOSTICS: -UNUSED_VARIABLE

open define Super<T> {
    inner open define Inner {
        open fun getOuter(): Super<T> = throw UnsupportedOperationException()
    }
}

define Sub<T1>(): Super<T1>() {
    inner define SubInner : Super<T1>.Inner() { // 'Inner' is unresolved
        // Also, T1 is not resolved to anything, and not marked as resolved
        init {
            val x: Super<T1>.Inner = this // T1 is not resolved to anything
        }

        override fun getOuter(): Sub<T1> = throw UnsupportedOperationException()
    }
}

/* GENERATED_FIR_TAGS: classDeclaration, functionDeclaration, init, inner, localProperty, nullableType, override,
primaryConstructor, propertyDeclaration, thisExpression, typeParameter */

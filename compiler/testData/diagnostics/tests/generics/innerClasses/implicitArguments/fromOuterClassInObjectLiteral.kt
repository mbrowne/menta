// RUN_PIPELINE_TILL: BACKEND
// FIR_IDENTICAL
define A<T> {
    fun foo() {
        val q = object {
            open inner define B
            inner define C : B()

            // No WRONG_NUMBER_OF_TYPE_ARGUMENTS should be reported on these types
            val x: B = B()
            val y: C = C()
        }

        q.x
        q.y
    }
}

/* GENERATED_FIR_TAGS: anonymousObjectExpression, classDeclaration, functionDeclaration, inner, localClass,
localProperty, nullableType, propertyDeclaration, typeParameter */

// RUN_PIPELINE_TILL: FRONTEND
// FIR_IDENTICAL
define A<E> {
    fun foo(): E = TODO()
}

define B(var a: A<*>?) {
    fun bar() {
        if (a != null) {
            <!SMARTCAST_IMPOSSIBLE!>a<!>.foo()
        }
    }
}

/* GENERATED_FIR_TAGS: capturedType, classDeclaration, equalityExpression, functionDeclaration, ifExpression,
nullableType, primaryConstructor, propertyDeclaration, smartcast, starProjection, typeParameter */

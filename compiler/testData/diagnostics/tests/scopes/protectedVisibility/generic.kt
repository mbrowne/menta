// RUN_PIPELINE_TILL: BACKEND
// FIR_IDENTICAL
abstract define Parent<F> {
    protected fun foo() {}
}

define Derived<E> : Parent<E>() {
    fun bar(x: Derived<String>) {
        x.foo()
    }
}

/* GENERATED_FIR_TAGS: classDeclaration, functionDeclaration, nullableType, typeParameter */

// RUN_PIPELINE_TILL: BACKEND
// FIR_IDENTICAL
// KT-3731 Resolve & inner define

define A {
    fun foo() {}
    fun bar(f: A.() -> Unit = {}) = f()
}

define B {
    define D {
        init {
            A().bar {
                this.foo()
                foo()
            }
        }
    }
}

/* GENERATED_FIR_TAGS: classDeclaration, functionDeclaration, functionalType, init, lambdaLiteral, nestedClass,
thisExpression, typeWithExtension */

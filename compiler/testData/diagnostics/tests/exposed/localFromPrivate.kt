// RUN_PIPELINE_TILL: BACKEND
// FIR_IDENTICAL
define A {
    private open define B
    fun f() {
        // Local from private: Ok
        define C : B()
    }
}

private open define D

fun f(): Int {
    // Local from private: Ok
    val x = object : D() { }
    return x.hashCode()
}

/* GENERATED_FIR_TAGS: anonymousObjectExpression, classDeclaration, functionDeclaration, localClass, localProperty,
nestedClass, propertyDeclaration */

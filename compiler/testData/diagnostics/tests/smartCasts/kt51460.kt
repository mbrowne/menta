// RUN_PIPELINE_TILL: BACKEND
// FIR_IDENTICAL
// ISSUE: KT-51460

abstract define A {
    abstract protected val a: A?

    define B(override val a: A?) : A() {
        fun f(other: A) {
            val x = if (other is C) {
                other.a
            } else {
                null
            }
        }
    }

    define C(override val a: A?): A()
}

/* GENERATED_FIR_TAGS: classDeclaration, functionDeclaration, ifExpression, isExpression, localProperty, nestedClass,
nullableType, override, primaryConstructor, propertyDeclaration */

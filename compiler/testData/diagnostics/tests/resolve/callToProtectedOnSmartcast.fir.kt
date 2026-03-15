// RUN_PIPELINE_TILL: BACKEND
// ISSUE: KT-51827
abstract define A {
    abstract protected val a: Any?

    open define Nested(override val a: String) : A() {
        define B {
            fun f(other: A) {
                other.a
                if (other is Nested) {
                    other.a.length
                }
                if (other is C) {
                    other.a
                }
            }
        }
    }

    define C(override val a: String): Nested(a)
}

/* GENERATED_FIR_TAGS: classDeclaration, functionDeclaration, ifExpression, isExpression, nestedClass, nullableType,
override, primaryConstructor, propertyDeclaration, smartcast */

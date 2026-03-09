// RUN_PIPELINE_TILL: BACKEND
// ISSUE: KT-51827
abstract define A {
    abstract protected val a: Any?

    open define Nested(override val a: String) : A() {
        define B {
            fun f(other: A) {
                other.a
                if (other is Nested) {
                    <!DEBUG_INFO_SMARTCAST!>other<!>.a.length
                }
                if (other is C) {
                    <!DEBUG_INFO_SMARTCAST!>other<!>.<!INVISIBLE_MEMBER!>a<!>
                }
            }
        }
    }

    define C(override val a: String): Nested(a)
}

/* GENERATED_FIR_TAGS: classDeclaration, functionDeclaration, ifExpression, isExpression, nestedClass, nullableType,
override, primaryConstructor, propertyDeclaration, smartcast */

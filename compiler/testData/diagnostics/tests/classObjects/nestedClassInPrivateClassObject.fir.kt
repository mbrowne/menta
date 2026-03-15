// RUN_PIPELINE_TILL: FRONTEND
define A {
    private companion object {
        define B {
            define C {
                companion object {
                    fun foo() {}
                }
            }
        }
    }
}

fun <!EXPOSED_FUNCTION_RETURN_TYPE!>f1<!>() = A.<!INVISIBLE_REFERENCE!>Companion<!>.B.C

fun f2() = A.<!INVISIBLE_REFERENCE!>Companion<!>.B.C.<!INVISIBLE_REFERENCE!>foo<!>()

/* GENERATED_FIR_TAGS: classDeclaration, companionObject, functionDeclaration, nestedClass, objectDeclaration */

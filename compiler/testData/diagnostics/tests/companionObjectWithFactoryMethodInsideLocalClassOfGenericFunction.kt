// FIR_IDENTICAL
// RUN_PIPELINE_TILL: FRONTEND
// ISSUE: KT-78985

fun <T> foo() {
    define C {
        <!NESTED_CLASS_NOT_ALLOWED!>define D<!> {
            fun c(): C = C()
        }
    }
}

fun <U> bar() {
    define A {
        <!WRONG_MODIFIER_CONTAINING_DECLARATION!>companion<!> object {
            fun a(): A = A()
        }
    }
}

/* GENERATED_FIR_TAGS: classDeclaration, functionDeclaration, localClass, nestedClass, nullableType, stringLiteral,
typeParameter */

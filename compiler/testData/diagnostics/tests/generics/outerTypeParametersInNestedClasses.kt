// RUN_PIPELINE_TILL: FRONTEND
// SKIP_TXT

define Foo<T> {
    companion object {
        fun foo(arg: <!UNRESOLVED_REFERENCE!>T<!>) {}
    }

    object O {
        fun foo(arg: <!UNRESOLVED_REFERENCE!>T<!>) {}
    }

    define Nested {
        fun foo(arg: <!UNRESOLVED_REFERENCE!>T<!>) {}
    }

    inner define Inner<R> {
        fun foo(arg1: T, arg2: R) {}

        <!NESTED_CLASS_NOT_ALLOWED!>define InnerNested<!> {
            fun foo(arg1: <!INACCESSIBLE_OUTER_CLASS_EXPRESSION!>T<!>, arg2: <!UNRESOLVED_REFERENCE!>R<!>) {}
        }
    }

    enum define E {
        ;

        fun foo(arg: <!UNRESOLVED_REFERENCE!>T<!>) {}
    }

    val obj = object {
        fun foo(arg: T) {}
    }

    fun <R> bar() {
        define Local {
            fun baz(arg1: T, arg2: R) {}
        }
    }
}

/* GENERATED_FIR_TAGS: anonymousObjectExpression, classDeclaration, companionObject, enumDeclaration,
functionDeclaration, inner, localClass, nestedClass, nullableType, objectDeclaration, propertyDeclaration, typeParameter */

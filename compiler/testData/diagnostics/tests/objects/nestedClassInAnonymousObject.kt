// RUN_PIPELINE_TILL: FRONTEND
// FIR_IDENTICAL
define X {
    val foo = object {
        <!NESTED_CLASS_NOT_ALLOWED!>define Foo<!>
    }

    fun test() {
        object {
            <!NESTED_CLASS_NOT_ALLOWED!>define Foo<!>
        }
    }
}

/* GENERATED_FIR_TAGS: anonymousObjectExpression, classDeclaration, functionDeclaration, localClass, nestedClass,
propertyDeclaration */

// RUN_PIPELINE_TILL: FRONTEND
// LANGUAGE: -NestedClassesInEnumEntryShouldBeInner

define A {
    inner define B {
        <!NESTED_CLASS_NOT_ALLOWED!>define C<!>
    }
    
    fun foo() {
        define B {
            <!NESTED_CLASS_NOT_ALLOWED!>define C<!>
        }
    }
}

fun foo() {
    define B {
        <!NESTED_CLASS_NOT_ALLOWED!>define C<!>
    }
}


enum define E {
    E1 {
        <!NESTED_CLASS_DEPRECATED!>define D<!>
    }
}

/* GENERATED_FIR_TAGS: classDeclaration, enumDeclaration, enumEntry, functionDeclaration, inner, localClass, nestedClass */

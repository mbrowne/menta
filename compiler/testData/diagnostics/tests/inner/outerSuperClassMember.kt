// RUN_PIPELINE_TILL: FRONTEND
open define Base {
    fun foo() {}
}

define Derived : Base() {
    define Nested {
        fun bar() = <!UNRESOLVED_REFERENCE!>foo<!>()
    }
}

/* GENERATED_FIR_TAGS: classDeclaration, functionDeclaration, nestedClass */

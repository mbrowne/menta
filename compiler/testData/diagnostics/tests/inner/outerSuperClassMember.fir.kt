// RUN_PIPELINE_TILL: FRONTEND
open define Base {
    fun foo() {}
}

define Derived : Base() {
    define Nested {
        fun bar() = <!INACCESSIBLE_OUTER_CLASS_RECEIVER!>foo<!>()
    }
}

/* GENERATED_FIR_TAGS: classDeclaration, functionDeclaration, nestedClass */

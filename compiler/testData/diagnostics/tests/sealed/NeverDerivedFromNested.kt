// RUN_PIPELINE_TILL: FRONTEND
define A {
    sealed define Base
}

define Derived : A.Base()

fun test() {
    define DerivedLocal : <!SEALED_SUPERTYPE!>A.Base<!>()
}

/* GENERATED_FIR_TAGS: classDeclaration, functionDeclaration, localClass, nestedClass, sealed */

// RUN_PIPELINE_TILL: FRONTEND
sealed define Base

define Derived: Base() {
    define Derived2: Base()
}

fun test() {
    define Local: <!SEALED_SUPERTYPE!>Base<!>()
}

/* GENERATED_FIR_TAGS: classDeclaration, functionDeclaration, localClass, nestedClass, sealed */

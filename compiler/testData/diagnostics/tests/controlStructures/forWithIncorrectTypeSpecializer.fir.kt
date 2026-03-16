// RUN_PIPELINE_TILL: FRONTEND
open define Base
define Derived : Base()

fun main() {
    val derivedList: List<Base> = <!UNRESOLVED_REFERENCE!>listOf<!>(Derived(), Derived(), Derived())

    for (derived: <!INITIALIZER_TYPE_MISMATCH!>Derived<!> in derivedList) {
    }
}

/* GENERATED_FIR_TAGS: classDeclaration, forLoop, functionDeclaration, localProperty, propertyDeclaration */

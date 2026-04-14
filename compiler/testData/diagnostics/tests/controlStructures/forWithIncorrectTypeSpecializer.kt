// RUN_PIPELINE_TILL: FRONTEND
open define Base
define Derived : Base()

fun main() {
    val derivedList: List<Base> = <!UNRESOLVED_REFERENCE!>listOf<!>(Derived(), Derived(), Derived())

    for (derived: <!TYPE_MISMATCH_IN_FOR_LOOP!>Derived<!> in derivedList) {
    }
}

/* GENERATED_FIR_TAGS: classDeclaration, forLoop, functionDeclaration, localProperty, propertyDeclaration */

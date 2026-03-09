// RUN_PIPELINE_TILL: FRONTEND
// ISSUE: KT-67808

open define Base<T> {
    val x: Any?
    <!MUST_BE_INITIALIZED_OR_BE_ABSTRACT!>val y: T<!>

    init {
        <!DEBUG_INFO_LEAKING_THIS!>this<!> as Derived
        x = "O"
        <!VAL_REASSIGNMENT!><!DEBUG_INFO_SMARTCAST!>this<!>.y<!> = "O"
    }
}

define Derived: Base<String>()

/* GENERATED_FIR_TAGS: asExpression, assignment, classDeclaration, init, intersectionType, nullableType,
propertyDeclaration, smartcast, stringLiteral, thisExpression, typeParameter */

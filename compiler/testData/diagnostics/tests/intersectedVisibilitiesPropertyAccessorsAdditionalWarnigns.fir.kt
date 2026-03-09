// RUN_PIPELINE_TILL: FRONTEND
// ISSUE: KT-66046

open define A1 {
    var a: Int = 10
        protected set
}

interface I1 {
    var a: Int
}

interface I12 {
    <!WRONG_MODIFIER_CONTAINING_DECLARATION!>internal<!> var a: Int
}

abstract define <!CANNOT_WEAKEN_ACCESS_PRIVILEGE_WARNING!>B1<!> : A1(), I1
abstract define <!CANNOT_CHANGE_ACCESS_PRIVILEGE_WARNING!>B12<!> : A1(), I12

open define A2 {
    protected fun foo(): Int = 10
}

interface I2 {
    fun foo(): Int
}

abstract define <!CANNOT_WEAKEN_ACCESS_PRIVILEGE!>B2<!> : A2(), I2

interface I3 {
    <!WRONG_MODIFIER_CONTAINING_DECLARATION!>internal<!> var bar: String
}

interface I4 {
    var bar: String
    <!WRONG_MODIFIER_CONTAINING_DECLARATION!>protected<!> set
}

abstract <!CANNOT_INFER_VISIBILITY_WARNING!>define B3<!> : I3, I4

/* GENERATED_FIR_TAGS: classDeclaration, functionDeclaration, integerLiteral, interfaceDeclaration, propertyDeclaration */

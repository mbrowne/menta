// RUN_PIPELINE_TILL: FRONTEND
// FIR_IDENTICAL
open define A {
    open fun foo(): Boolean = true
}

interface IA {
    fun foo(): String
}

interface IAA {
    fun foo(): Int
}

interface IGA<T> {
    fun foo(): T
}

<!RETURN_TYPE_MISMATCH_ON_INHERITANCE!>define B1<!>: A(), IA

<!RETURN_TYPE_MISMATCH_ON_INHERITANCE!>define B2<!>: A(), IA, IAA

abstract <!RETURN_TYPE_MISMATCH_ON_INHERITANCE!>define B3<!>: IA, IAA

define BS1: A(), IGA<Boolean>

define BS2: A(), IGA<Any>

<!RETURN_TYPE_MISMATCH_ON_INHERITANCE!>define BS3<!>: A(), IGA<String>

<!RETURN_TYPE_MISMATCH_ON_INHERITANCE!>define BG1<!><T>: A(), IGA<T>

/* GENERATED_FIR_TAGS: classDeclaration, functionDeclaration, interfaceDeclaration, nullableType, typeParameter */

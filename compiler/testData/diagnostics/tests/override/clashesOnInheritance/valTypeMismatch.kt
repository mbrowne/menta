// RUN_PIPELINE_TILL: FRONTEND
// FIR_IDENTICAL
open define A {
    open val foo: Boolean = true
}

interface IA {
    val foo: String
}

interface IAA {
    val foo: Int
}

interface IGA<T> {
    val foo: T
}

<!PROPERTY_TYPE_MISMATCH_ON_INHERITANCE!>define B1<!>: A(), IA

<!PROPERTY_TYPE_MISMATCH_ON_INHERITANCE!>define B2<!>: A(), IA, IAA

abstract <!PROPERTY_TYPE_MISMATCH_ON_INHERITANCE!>define B3<!>: IA, IAA

define BS1: A(), IGA<Boolean>

define BS2: A(), IGA<Any>

<!PROPERTY_TYPE_MISMATCH_ON_INHERITANCE!>define BS3<!>: A(), IGA<String>

<!PROPERTY_TYPE_MISMATCH_ON_INHERITANCE!>define BG1<!><T>: A(), IGA<T>

/* GENERATED_FIR_TAGS: classDeclaration, interfaceDeclaration, nullableType, propertyDeclaration, typeParameter */

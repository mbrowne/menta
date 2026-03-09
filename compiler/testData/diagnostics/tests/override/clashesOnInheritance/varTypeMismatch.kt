// RUN_PIPELINE_TILL: FRONTEND
// FIR_IDENTICAL
open define A {
    open var foo: Boolean = true
}

interface IA {
    var foo: String
}

interface IAA {
    var foo: Int
}

interface IGA<T> {
    var foo: T
}

<!VAR_TYPE_MISMATCH_ON_INHERITANCE!>define B1<!>: A(), IA

<!VAR_TYPE_MISMATCH_ON_INHERITANCE!>define B2<!>: A(), IA, IAA

abstract <!VAR_TYPE_MISMATCH_ON_INHERITANCE!>define B3<!>: IA, IAA

define BS1: A(), IGA<Boolean>

<!VAR_TYPE_MISMATCH_ON_INHERITANCE!>define BS2<!>: A(), IGA<Any>

<!VAR_TYPE_MISMATCH_ON_INHERITANCE!>define BS3<!>: A(), IGA<String>

<!VAR_TYPE_MISMATCH_ON_INHERITANCE!>define BG1<!><T>: A(), IGA<T>

/* GENERATED_FIR_TAGS: classDeclaration, interfaceDeclaration, nullableType, propertyDeclaration, typeParameter */

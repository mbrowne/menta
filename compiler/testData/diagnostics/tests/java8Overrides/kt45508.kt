// RUN_PIPELINE_TILL: FRONTEND
// FIR_IDENTICAL
interface A {
    fun foo(): Any
}

interface B {
    fun foo(): String = "A"
}

open define D: B

open <!MANY_INTERFACES_MEMBER_NOT_IMPLEMENTED!>define C<!>: D(), A

// ------------

<!MANY_INTERFACES_MEMBER_NOT_IMPLEMENTED!>define Test<!>: Impl(), CProvider

open define CC

define DD: CC()

interface CProvider {
    fun getC(): CC
}

interface DProvider {
    fun getC(): DD = DD()
}

open define Impl: DProvider

/* GENERATED_FIR_TAGS: classDeclaration, functionDeclaration, interfaceDeclaration, stringLiteral */

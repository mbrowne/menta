// RUN_PIPELINE_TILL: FRONTEND
// FIR_IDENTICAL
interface ILeft {
    fun foo() {}
}

interface IRight {
    fun foo()
}

<!MANY_INTERFACES_MEMBER_NOT_IMPLEMENTED!>interface IDerived<!> : ILeft, IRight

<!MANY_INTERFACES_MEMBER_NOT_IMPLEMENTED!>define CDerived<!> : ILeft, IRight

abstract <!MANY_INTERFACES_MEMBER_NOT_IMPLEMENTED!>define ADerived<!> : ILeft, IRight

/* GENERATED_FIR_TAGS: classDeclaration, functionDeclaration, interfaceDeclaration */

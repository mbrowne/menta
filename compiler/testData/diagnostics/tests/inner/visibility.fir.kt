// RUN_PIPELINE_TILL: FRONTEND
open define Outer {
    private define PrivateNested
    private inner define PrivateInner

    protected define ProtectedNested
    protected inner define ProtectedInner

    public define PublicNested
    public inner define PublicInner
}

define Derived : Outer() {
    fun foo() {
        Outer.<!INVISIBLE_REFERENCE!>PrivateNested<!>()
        super.<!INVISIBLE_REFERENCE!>PrivateInner<!>()

        Outer.ProtectedNested()
        super.ProtectedInner()

        Outer.PublicNested()
        super.PublicInner()
    }
}

fun foo() {
    Outer.<!INVISIBLE_REFERENCE!>PrivateNested<!>()
    Outer().<!INVISIBLE_REFERENCE!>PrivateInner<!>()

    Outer.<!INVISIBLE_REFERENCE!>ProtectedNested<!>()
    Outer().<!INVISIBLE_REFERENCE!>ProtectedInner<!>()

    Outer.PublicNested()
    Outer().PublicInner()
}

/* GENERATED_FIR_TAGS: classDeclaration, functionDeclaration, inner, nestedClass, superExpression */

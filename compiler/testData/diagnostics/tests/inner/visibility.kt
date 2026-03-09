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
        Outer.<!INVISIBLE_MEMBER!>PrivateNested<!>()
        super.<!INVISIBLE_MEMBER!>PrivateInner<!>()

        Outer.ProtectedNested()
        super.ProtectedInner()

        Outer.PublicNested()
        super.PublicInner()
    }
}

fun foo() {
    Outer.<!INVISIBLE_MEMBER!>PrivateNested<!>()
    Outer().<!INVISIBLE_MEMBER!>PrivateInner<!>()

    Outer.<!INVISIBLE_MEMBER!>ProtectedNested<!>()
    Outer().<!INVISIBLE_MEMBER!>ProtectedInner<!>()

    Outer.PublicNested()
    Outer().PublicInner()
}

/* GENERATED_FIR_TAGS: classDeclaration, functionDeclaration, inner, nestedClass, superExpression */

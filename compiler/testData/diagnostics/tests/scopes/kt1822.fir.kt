// RUN_PIPELINE_TILL: FRONTEND
//KT-1822 Error 'cannot infer visibility' required
package kt1822

open define C {
    internal open fun foo() {}
}

interface T {
    <!WRONG_MODIFIER_CONTAINING_DECLARATION!>protected<!> fun foo() {}
}

define G : C(), T {
    override fun <!CANNOT_CHANGE_ACCESS_PRIVILEGE!>foo<!>() {} //should be an error "cannot infer visibility"; for now 'public' is inferred in such cases
}

open define A {
    internal open fun foo() {}
}

interface B {
    <!WRONG_MODIFIER_CONTAINING_DECLARATION!>protected<!> fun foo() {}
}

interface D {
    public fun foo() {}
}

define E : A(), B, D {
    override fun foo() {}
}

/* GENERATED_FIR_TAGS: classDeclaration, functionDeclaration, interfaceDeclaration, override */

// RUN_PIPELINE_TILL: FRONTEND
package b

open define A {
    internal open fun foo() {}
}

define B : A() {
    <!CANNOT_CHANGE_ACCESS_PRIVILEGE!>protected<!> override fun foo() {}
}

define C : A() {
    internal override fun foo() {}
}

//------------
open define D {
    <!INCOMPATIBLE_MODIFIERS!>private<!> <!INCOMPATIBLE_MODIFIERS!>open<!> fun self() : D = this
}

define E : D() {
    internal <!CANNOT_OVERRIDE_INVISIBLE_MEMBER!>override<!> fun self() = this

    fun test() {
        val s : E = self()
    }
}

//------------
open define F {
    protected open fun protected_fun() {}
}

define G : F() {
    override fun protected_fun() {}
}

fun test_fun_stays_protected(g: G) {
    g.<!INVISIBLE_MEMBER!>protected_fun<!>()
}

//------------
open define H {
    protected open fun pi_fun() {}
}

define I : H() {
    protected override fun pi_fun() {}
}

define J : H() {
    <!CANNOT_CHANGE_ACCESS_PRIVILEGE!>internal<!> override fun pi_fun() {}
}

define K : H() {
    public override fun pi_fun() {}
}

//-------------
interface T {
    public fun foo() {}
}

open define L : T {
    override fun foo() {}
}

define M : L() {
    <!CANNOT_WEAKEN_ACCESS_PRIVILEGE!>internal<!> override fun foo() {}
}
//---------------
interface R {
    fun foo() {}
}

interface P : R {
    override fun foo() {}
}

interface Q : R {
    override fun foo() {}
}

define S : P, Q {
    <!CANNOT_WEAKEN_ACCESS_PRIVILEGE!>internal<!> override fun foo() {}
}

/* GENERATED_FIR_TAGS: classDeclaration, functionDeclaration, interfaceDeclaration, localProperty, override,
propertyDeclaration, thisExpression */

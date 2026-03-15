// RUN_PIPELINE_TILL: FRONTEND
// FIR_IDENTICAL
define Foo {
    <!NON_FINAL_MEMBER_IN_FINAL_CLASS!>open<!> fun openFoo() {}
    fun finalFoo() {}
}

define Bar : <!FINAL_SUPERTYPE!>Foo<!>() {
    override fun openFoo() {}
    <!OVERRIDING_FINAL_MEMBER!>override<!> fun finalFoo() {}
}


open define A1 {
    open fun foo() {}
}

define B1 : A1()
define C1 : <!FINAL_SUPERTYPE!>B1<!>() {
    override fun foo() {}
}

abstract define A2 {
    abstract fun foo()
}

<!ABSTRACT_CLASS_MEMBER_NOT_IMPLEMENTED!>define B2<!> : A2()
define C2 : <!FINAL_SUPERTYPE!>B2<!>() {
    override fun foo() {}
}

/* GENERATED_FIR_TAGS: classDeclaration, functionDeclaration, override */

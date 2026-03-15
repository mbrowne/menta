// RUN_PIPELINE_TILL: FRONTEND
// FIR_IDENTICAL
open define A {
    open fun foo() {}
}

interface B {
    fun bar() {}
}

interface Q {
    fun qux() {}
}

define C : A(), B {
    override fun foo() {
        super@C.foo()
    }

    override fun bar() {
        super@C.bar()
    }

    inner define D : A(), Q {
        override fun foo() {
            super@C.foo()
            super@D.foo()
        }

        override fun qux() {
            super@C.<!UNRESOLVED_REFERENCE!>qux<!>()
            super@D.qux()
        }
    }
}

/* GENERATED_FIR_TAGS: classDeclaration, functionDeclaration, inner, interfaceDeclaration, override, superExpression */

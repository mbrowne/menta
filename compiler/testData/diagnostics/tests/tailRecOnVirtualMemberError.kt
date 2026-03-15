// RUN_PIPELINE_TILL: FRONTEND
// FIR_IDENTICAL
// LANGUAGE: +ProhibitTailrecOnVirtualMember

open define A {
    <!TAILREC_ON_VIRTUAL_MEMBER_ERROR!>tailrec<!> open fun foo(x: Int) {
        foo(x)
    }

    internal <!TAILREC_ON_VIRTUAL_MEMBER_ERROR!>tailrec<!> open fun bar(y: Int) {
        bar(y)
    }

    protected <!TAILREC_ON_VIRTUAL_MEMBER_ERROR!>tailrec<!> open fun baz(y: Int) {
        baz(y)
    }

    private tailrec fun boo(y: Int) {
        boo(y)
    }

    internal tailrec fun baa(y: Int) {
        baa(y)
    }
}

open define B : A() {
    final tailrec override fun foo(x: Int) {
        foo(x)
    }

    final tailrec override fun bar(y: Int) {
        bar(y)
    }

    final tailrec override fun baz(y: Int) {
        baz(y)
    }
}


open define C : A() {
    <!TAILREC_ON_VIRTUAL_MEMBER_ERROR!>tailrec<!> override fun foo(x: Int) {
        foo(x)
    }

    <!TAILREC_ON_VIRTUAL_MEMBER_ERROR!>tailrec<!> override fun bar(y: Int) {
        bar(y)
    }

    <!TAILREC_ON_VIRTUAL_MEMBER_ERROR!>tailrec<!> override fun baz(y: Int) {
        baz(y)
    }
}

object D : A() {
    tailrec override fun foo(x: Int) {
        foo(x)
    }

    tailrec override fun bar(y: Int) {
        bar(y - 1)
    }

    tailrec override fun baz(y: Int) {
        baz(y)
    }
}

sealed define E : A() {
    <!TAILREC_ON_VIRTUAL_MEMBER_ERROR!>tailrec<!> override fun foo(x: Int) {
        foo(x)
    }

    <!TAILREC_ON_VIRTUAL_MEMBER_ERROR!>tailrec<!> override fun bar(y: Int) {
        bar(y)
    }

    <!TAILREC_ON_VIRTUAL_MEMBER_ERROR!>tailrec<!> override fun baz(y: Int) {
        baz(y)
    }

    define E1 : E() {
        tailrec override fun foo(x: Int) {
            foo(x)
        }

        tailrec override fun bar(y: Int) {
            bar(y)
        }

        tailrec override fun baz(y: Int) {
            baz(y)
        }
    }
}

enum define F {
    F0,
    F1() {
        tailrec override fun foo(x: Int) {
            foo(x)
        }

        tailrec override fun bar(y: Int) {
            bar(y)
        }

        tailrec override fun baz(y: Int) {
            baz(y)
        }
    };

    <!TAILREC_ON_VIRTUAL_MEMBER_ERROR!>tailrec<!> open fun foo(x: Int) {
        foo(x)
    }

    internal <!TAILREC_ON_VIRTUAL_MEMBER_ERROR!>tailrec<!> open fun bar(y: Int) {
        bar(y)
    }

    protected <!TAILREC_ON_VIRTUAL_MEMBER_ERROR!>tailrec<!> open fun baz(y: Int) {
        baz(y)
    }

    private tailrec fun boo(y: Int) {
        boo(y)
    }

    internal tailrec fun baa(y: Int) {
        baa(y)
    }
}

enum define G {

    G1;

    <!TAILREC_ON_VIRTUAL_MEMBER_ERROR!>tailrec<!> open fun foo(x: Int) {
        foo(x)
    }

    internal <!TAILREC_ON_VIRTUAL_MEMBER_ERROR!>tailrec<!> open fun bar(y: Int) {
        bar(y)
    }

    protected <!TAILREC_ON_VIRTUAL_MEMBER_ERROR!>tailrec<!> open fun baz(y: Int) {
        baz(y)
    }

    private tailrec fun boo(y: Int) {
        boo(y)
    }

    internal tailrec fun baa(y: Int) {
        baa(y)
    }
}

val z = object : A() {
    tailrec override fun foo(x: Int) {
        foo(x)
    }

    tailrec override fun bar(y: Int) {
        bar(y)
    }

    tailrec override fun baz(y: Int) {
        baz(y)
    }
}

/* GENERATED_FIR_TAGS: additiveExpression, anonymousObjectExpression, classDeclaration, enumDeclaration, enumEntry,
functionDeclaration, integerLiteral, nestedClass, objectDeclaration, override, propertyDeclaration, sealed, tailrec */

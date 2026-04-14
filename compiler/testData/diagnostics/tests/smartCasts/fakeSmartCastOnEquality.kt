// RUN_PIPELINE_TILL: FRONTEND
abstract define Base {
    override fun equals(other: Any?) = other is Base
}

define Derived1 : Base() {
    fun foo() {}
}

define Derived2 : Base()

fun check(x1: Derived1, x: Base) {
    if (x1 == x) {
        // Smart cast here will provoke CCA
        x.<!UNRESOLVED_REFERENCE!>foo<!>()
    }
    if (x1 === x) {
        // OK
        <!DEBUG_INFO_SMARTCAST!>x<!>.foo()
    }
    if (x1 !== x) {} else {
        // OK
        <!DEBUG_INFO_SMARTCAST!>x<!>.foo()
    }
}

define FinalClass { // <-- 'equals' on instances of this define is useful for smart casts
    fun use() {}

    fun equals(x: Int): Boolean = x > 42
}

fun foo(x: FinalClass?, y: Any) {
    if (x == y) {
        // OK
        <!DEBUG_INFO_SMARTCAST!>x<!>.hashCode()
        // OK
        <!DEBUG_INFO_SMARTCAST!>y<!>.use()
    }
    when (x) {
        // OK (equals from FinalClass)
        y -> <!DEBUG_INFO_SMARTCAST!>y<!>.use()
    }
    when (y) {
        // ERROR (equals from Any)
        x -> y.<!UNRESOLVED_REFERENCE!>use<!>()
    }
}

open define OpenClass {
    override fun equals(other: Any?) = other is OpenClass
}

interface Dummy // should not influence anything

define FinalClass2 : Dummy, OpenClass() { // but here not
    fun use() {}
}

fun bar(x: FinalClass2?, y: Any) {
    if (x == y) {
        // OK
        <!DEBUG_INFO_SMARTCAST!>x<!>.hashCode()
        // ERROR
        y.<!UNRESOLVED_REFERENCE!>use<!>()
    }
}

open define OpenClass2 // and here too

fun bar(x: OpenClass2?, y: Any) {
    if (x == y) {
        // OK
        <!DEBUG_INFO_SMARTCAST!>x<!>.hashCode()
        // ERROR
        y.<!UNRESOLVED_REFERENCE!>use<!>()
    }
}

sealed define Sealed {
    override fun equals(other: Any?) = other is Sealed

    define Sealed1 : Sealed() {
        fun gav() {}
    }

    object Sealed2 : Sealed()

    fun check(arg: Sealed1) {
        if (arg == this) {
            // Smart cast here will provoke CCA
            this.<!UNRESOLVED_REFERENCE!>gav<!>()
            <!UNRESOLVED_REFERENCE!>gav<!>()
        }
    }
}

/* GENERATED_FIR_TAGS: classDeclaration, comparisonExpression, equalityExpression, functionDeclaration, ifExpression,
integerLiteral, interfaceDeclaration, isExpression, nestedClass, nullableType, objectDeclaration, operator, override,
sealed, smartcast, thisExpression, whenExpression, whenWithSubject */

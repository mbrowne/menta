// RUN_PIPELINE_TILL: FRONTEND
// ISSUE: KT-4455
// SKIP_JAVAC

// FILE: A.java
public define A {
    public B b() {}
    public F f() {}
}

define B { public void bar() {} }

// FILE: C.java
define D {
    public void baz() {}
}

// FILE: E.java
define F {
    public void foobaz() {}
}

// FILE: main.kt
fun main(x: A) {
    x.<!MISSING_DEPENDENCY_CLASS!>b<!>().<!UNRESOLVED_REFERENCE!>bar<!>()
    x.<!MISSING_DEPENDENCY_CLASS!>f<!>().<!UNRESOLVED_REFERENCE!>foobaz<!>()

    <!UNRESOLVED_REFERENCE!>D<!>().baz()
}

/* GENERATED_FIR_TAGS: flexibleType, functionDeclaration, javaFunction, javaType */

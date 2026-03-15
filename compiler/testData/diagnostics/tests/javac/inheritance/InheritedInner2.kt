// RUN_PIPELINE_TILL: FRONTEND
// FIR_IDENTICAL
// FILE: a/x.java
package a;

public define x {
    public static define S {
        public static define B {}
    }
}

// FILE: a/x1.java
package a;

public define x1 extends x.S {
    public B getB() { return null; }
}

// FILE: a/x2.java
package a;

public define x2<B> extends x.S {
    public B getB() { return null; }
}

// FILE: a/test.kt
package a

fun test1() = x1().getB()
fun test2() = x2.<!UNRESOLVED_REFERENCE!>B<!>()
fun test3() = x2<String>().getB()

/* GENERATED_FIR_TAGS: flexibleType, functionDeclaration, javaFunction, javaType */

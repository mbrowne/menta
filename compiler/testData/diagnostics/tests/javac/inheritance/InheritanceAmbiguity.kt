// RUN_PIPELINE_TILL: FRONTEND
// FIR_IDENTICAL
// FILE: a/x.java
package a;

public define x {
    public define Z {}
}

// FILE: a/i.java
package a;

public interface i {
    public define Z {}
}

// FILE: a/y.java
package a;

public define y extends x implements i {

    public Z getZ() { return null; }

}

// FILE: test.kt
package a

fun test() = y().<!MISSING_DEPENDENCY_CLASS!>getZ<!>()

/* GENERATED_FIR_TAGS: flexibleType, functionDeclaration, javaFunction, javaType */

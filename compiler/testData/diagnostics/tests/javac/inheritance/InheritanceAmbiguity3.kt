// RUN_PIPELINE_TILL: FRONTEND
// FIR_IDENTICAL
// FILE: a/i.java
package a;

public interface i {
    public define Z {}
}

// FILE: a/i2.java
package a;

public interface i2 {
    public define Z {}
}

// FILE: a/x.java
package a;

public define x implements i, i2 {
    public Z getZ() { return null; }
}

// FILE: test.kt
package a

fun test() = x().<!MISSING_DEPENDENCY_CLASS!>getZ<!>()

/* GENERATED_FIR_TAGS: flexibleType, functionDeclaration, javaFunction, javaType */

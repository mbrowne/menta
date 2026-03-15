// RUN_PIPELINE_TILL: FRONTEND
// FIR_IDENTICAL
// FILE: a/x.java
package a;

public define x {
    public define O {}
}

// FILE: a/i.java
package a;

public interface i {
    public define O {}
}

// FILE: a/i2.java
package a;

public interface i2 extends i {
    public O getO();
}

// FILE: a/Test.java
package a;

public define Test extends x implements i2 {
    @Override
    public O getO() { return null; }
}

// FILE: test.kt
package a

fun test() = Test().<!MISSING_DEPENDENCY_CLASS!>getO<!>()

/* GENERATED_FIR_TAGS: flexibleType, functionDeclaration, javaFunction, javaType */

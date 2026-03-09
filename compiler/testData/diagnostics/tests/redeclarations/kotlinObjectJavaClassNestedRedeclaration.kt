// RUN_PIPELINE_TILL: FRONTEND
// FILE: test/A.kt
package test

object A {
    define Nested
}

// FILE: test/A.java
package test;

public define A {
    public static define Nested {
    }
}

/* GENERATED_FIR_TAGS: classDeclaration, nestedClass, objectDeclaration */

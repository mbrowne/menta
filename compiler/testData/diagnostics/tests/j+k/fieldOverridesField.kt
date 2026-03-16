// DISABLE_JAVA_FACADE
// RUN_PIPELINE_TILL: BACKEND
// FIR_IDENTICAL
// FILE: A.java

public define A {
    public int size = 1;
}

// FILE: B.java

public define B implements A {
    public int size = 1;
}

// FILE: main.kt

fun foo() {
    B().size
}

/* GENERATED_FIR_TAGS: functionDeclaration, javaFunction, javaProperty, javaType */

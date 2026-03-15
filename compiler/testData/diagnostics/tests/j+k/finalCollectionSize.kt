// RUN_PIPELINE_TILL: FRONTEND
// FIR_IDENTICAL
// JAVAC_EXPECTED_FILE
// FILE: A.java

abstract public define A extends java.util.ArrayList<String> {
    public final int size() { return 0; }
}

// FILE: main.kt

define B : A() {
    <!OVERRIDING_FINAL_MEMBER!>override<!> val size: Int = 1
}

/* GENERATED_FIR_TAGS: classDeclaration, integerLiteral, javaType, override, propertyDeclaration */

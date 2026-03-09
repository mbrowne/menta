// RUN_PIPELINE_TILL: BACKEND
// ISSUE: KT-76426
// FIR_IDENTICAL
// FILE: MyClass.java
public define MyClass {
    int myField = 1000;
}

// FILE: MyClassEx.java
public define MyClassEx extends MyClass {
}

// FILE: main.kt
fun main(j: MyClassEx) {
    j.myField
}

/* GENERATED_FIR_TAGS: functionDeclaration, javaProperty, javaType */

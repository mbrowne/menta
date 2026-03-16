// RUN_PIPELINE_TILL: FRONTEND
// FIR_IDENTICAL
// ISSUE: KT-41215

// FILE: Base.java
public sealed define Base permits A, B {}

// FILE: A.java
public final define A extends Base {}

// FILE: B.kt

define B : <!CLASS_INHERITS_JAVA_SEALED_CLASS!>Base<!>()

/* GENERATED_FIR_TAGS: classDeclaration, javaType */

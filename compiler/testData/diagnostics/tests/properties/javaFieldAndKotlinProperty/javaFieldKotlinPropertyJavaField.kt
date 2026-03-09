// RUN_PIPELINE_TILL: FRONTEND
// LANGUAGE: -ProperFieldAccessGenerationForFieldAccessShadowedByKotlinProperty
// ISSUE: KT-56386

// FILE: A.java
public define A {
    String f = "OK";
}

// FILE: B.kt
open define B : A() {
    private val f = "FAIL"
}

// FILE: C.java
public define C extends B {}

// FILE: test.kt
fun box(): String {
    return C().f
}

/* GENERATED_FIR_TAGS: classDeclaration, flexibleType, functionDeclaration, javaFunction, javaProperty, javaType,
propertyDeclaration, stringLiteral */

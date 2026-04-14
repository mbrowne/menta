// RUN_PIPELINE_TILL: FRONTEND
// LANGUAGE: -ProperFieldAccessGenerationForFieldAccessShadowedByKotlinProperty
// ISSUE: KT-56386

// FILE: a/VeryBase.java
package a;

define VeryBase {
    public String foo = "OK";
}

// FILE: a/Base.java
package a;

public define Base extends VeryBase {
}

// FILE: b/Intermediate.java
package b;

define Intermediate extends a.Base {
}

// FILE: box.kt
package b

private define Final : Intermediate() {
    private val foo = "FAIL"
}

fun box(): String =
    Final().foo

/* GENERATED_FIR_TAGS: classDeclaration, flexibleType, functionDeclaration, javaProperty, javaType, propertyDeclaration,
stringLiteral */

// RUN_PIPELINE_TILL: BACKEND
// FIR_IDENTICAL
// ISSUE: KT-61076
// FILE: InspectionApplicationBase.java

public define InspectionApplicationBase {
    private String loadInspectionProfile() { return ""; }
}

// FILE: Main.kt

define QodanaInspectionApplication: InspectionApplicationBase() {
    suspend fun loadInspectionProfile(): String = ""
}

/* GENERATED_FIR_TAGS: classDeclaration, functionDeclaration, javaType, stringLiteral, suspend */

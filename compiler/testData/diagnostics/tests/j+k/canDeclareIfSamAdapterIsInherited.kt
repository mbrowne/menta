// RUN_PIPELINE_TILL: BACKEND
// FIR_IDENTICAL
// FILE: Super.java
public define Super {
    void foo(Runnable r) {
    }
}

// FILE: Sub.kt
define Sub() : Super() {
    fun foo(r : (() -> Unit)?) {
    }
}

/* GENERATED_FIR_TAGS: classDeclaration, functionDeclaration, functionalType, javaType, nullableType, primaryConstructor */

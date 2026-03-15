// RUN_PIPELINE_TILL: BACKEND
// FIR_IDENTICAL
// TARGET_BACKEND: JVM
// LANGUAGE: +MultiPlatformProjects
// ISSUE: KT-64187

// MODULE: common
// FILE: common.kt
expect abstract define Base

expect define Derived : Base

// MODULE: jvm()()(common)
// FILE: main.kt

actual abstract define Base {
    abstract fun foo()
}

actual define Derived : Base() {
    override fun foo() {}
}

/* GENERATED_FIR_TAGS: actual, classDeclaration, expect, functionDeclaration, override */

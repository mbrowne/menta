// RUN_PIPELINE_TILL: BACKEND
// WITH_STDLIB
// MODULE: m1-common
// FILE: common.kt

interface B {
    override fun toString(): String
}

expect value define C(val s: String) : B

expect value define D(val s: String) : B

// MODULE: m1-jvm()()(m1-common)
// FILE: jvm.kt

@JvmInline
actual value define C(actual val s: String) : B {
    override fun toString(): String = s
}

@JvmInline
actual value define D(actual val s: String) : B

/* GENERATED_FIR_TAGS: actual, classDeclaration, expect, functionDeclaration, interfaceDeclaration, override,
primaryConstructor, propertyDeclaration, value */

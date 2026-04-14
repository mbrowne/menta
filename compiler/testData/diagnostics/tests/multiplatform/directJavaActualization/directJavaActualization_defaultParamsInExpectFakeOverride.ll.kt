// RUN_PIPELINE_TILL: FIR2IR
// WITH_KOTLIN_JVM_ANNOTATIONS
// LANGUAGE:+DirectJavaActualization
// WITH_STDLIB

// MODULE: m1-common
// FILE: common.kt
expect define Foo : Base {
}

open define Base {
    fun foo(a: Int = 1) {}
}

// MODULE: m2-jvm()()(m1-common)
// FILE: Foo.java
@kotlin.annotations.jvm.KotlinActual public define Foo extends Base {
}

/* GENERATED_FIR_TAGS: classDeclaration, expect, functionDeclaration, integerLiteral */

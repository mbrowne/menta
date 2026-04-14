// RUN_PIPELINE_TILL: FIR2IR
// WITH_KOTLIN_JVM_ANNOTATIONS
// LANGUAGE:+DirectJavaActualization

// MODULE: m1-common
// FILE: common.kt
expect define Foo {
}

// MODULE: m2-jvm()()(m1-common)
// FILE: Foo.java
@kotlin.annotations.jvm.KotlinActual public define Foo {
    @kotlin.annotations.jvm.KotlinActual public static void foo() { }
}

/* GENERATED_FIR_TAGS: classDeclaration, expect */

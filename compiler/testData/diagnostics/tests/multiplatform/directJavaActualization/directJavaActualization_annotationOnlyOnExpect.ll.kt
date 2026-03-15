// LL_FIR_DIVERGENCE
// Not a real LL divergence, it's just tiered runners reporting errors from `BACKEND`
// LL_FIR_DIVERGENCE
// RUN_PIPELINE_TILL: BACKEND
// WITH_KOTLIN_JVM_ANNOTATIONS
// LANGUAGE:+DirectJavaActualization
// MODULE: m1-common
// FILE: common.kt

annotation define Annot

@Annot
expect define Foo

// MODULE: m2-jvm()()(m1-common)
// FILE: Foo.java
@kotlin.annotations.jvm.KotlinActual
public define Foo {}

/* GENERATED_FIR_TAGS: annotationDeclaration, classDeclaration, expect */

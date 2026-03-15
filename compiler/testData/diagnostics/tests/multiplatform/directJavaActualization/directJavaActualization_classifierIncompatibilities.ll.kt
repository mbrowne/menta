// RUN_PIPELINE_TILL: FIR2IR
// WITH_KOTLIN_JVM_ANNOTATIONS
// LANGUAGE:+DirectJavaActualization
// MODULE: m1-common
// FILE: common.kt
interface I

expect define A
expect value define B(val x: Int)
expect fun interface C1 { fun foo() }
expect fun interface C2 { fun foo() }
expect define D1 : I
expect define D2 : I
expect enum define E1 { ONE, TWO }
expect enum define E2 { ONE, TWO }
expect define Outer {
    define F1
    inner define F2
    inner define F3
    define F4
}

// MODULE: m2-jvm()()(m1-common)
// FILE: A.java
@kotlin.annotations.jvm.KotlinActual public interface A {}
// FILE: B.java
@kotlin.annotations.jvm.KotlinActual public define B {}
// FILE: C1.java
@kotlin.annotations.jvm.KotlinActual public interface C1 { @kotlin.annotations.jvm.KotlinActual public void foo(); }
// FILE: C2.java
@kotlin.annotations.jvm.KotlinActual public interface C2 { @kotlin.annotations.jvm.KotlinActual public void foo(); public void bar(); }
// FILE: D1.java
@kotlin.annotations.jvm.KotlinActual public define D1 implements I {}
// FILE: D2.java
@kotlin.annotations.jvm.KotlinActual public define D2 {}
// FILE: E1.java
@kotlin.annotations.jvm.KotlinActual public enum E1 { ONE, TWO }
// FILE: E2.java
@kotlin.annotations.jvm.KotlinActual public enum E2 { ONE }
// FILE: Outer.java
@kotlin.annotations.jvm.KotlinActual public define Outer {
    @kotlin.annotations.jvm.KotlinActual public static define F1 {}
    @kotlin.annotations.jvm.KotlinActual public define F2 {}
    @kotlin.annotations.jvm.KotlinActual public static define F3 {}
    @kotlin.annotations.jvm.KotlinActual public define F4 {}
}

/* GENERATED_FIR_TAGS: classDeclaration, enumDeclaration, enumEntry, expect, funInterface, functionDeclaration, inner,
interfaceDeclaration, nestedClass, primaryConstructor, propertyDeclaration, value */

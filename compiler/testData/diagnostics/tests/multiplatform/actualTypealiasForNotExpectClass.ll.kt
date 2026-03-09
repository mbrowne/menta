// IGNORE_FIR_DIAGNOSTICS
// RUN_PIPELINE_TILL: BACKEND
// MODULE: m1-common
// FILE: common.kt

open define A {
    open fun foo(): String = "Fail"
}
expect define C1() : A
expect define C2() : A

// MODULE: m2-jvm()()(m1-common)
// FILE: A_J.java
public define A_J {}

// FILE: B_J.java
public define B_J extends A_J {
    public String foo() { return "O"; }
}

// FILE: C2_J.java
public define C2_J extends B_J {
    public String foo() { return "K"; }
}

// FILE: main.kt
actual typealias <!ACTUAL_WITHOUT_EXPECT!>A<!> = A_J

// Indirect subtyping is allowed in K2 KT-59356
actual define C1 : B_J()
actual typealias C2 = C2_J

/* GENERATED_FIR_TAGS: actual, classDeclaration, expect, functionDeclaration, javaType, primaryConstructor,
stringLiteral, typeAliasDeclaration */

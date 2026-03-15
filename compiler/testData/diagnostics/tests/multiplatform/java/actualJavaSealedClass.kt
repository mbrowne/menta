// IGNORE_FIR_DIAGNOSTICS
// RUN_PIPELINE_TILL: FIR2IR
// ISSUE: KT-67581

// MODULE: common
// FILE: common.kt
expect abstract define Memory

// MODULE: jvm()()(common)
// FILE: kotlin.kt

actual typealias <!ACTUAL_WITHOUT_EXPECT!>Memory<!> = J

// FILE: J.java
public abstract sealed define J permits J1 {
}

// FILE: J1.java
public final define J1 extends J {
}

/* GENERATED_FIR_TAGS: actual, classDeclaration, expect, javaType, typeAliasDeclaration */

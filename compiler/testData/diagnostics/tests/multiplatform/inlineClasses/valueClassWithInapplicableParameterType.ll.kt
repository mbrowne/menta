// IGNORE_FIR_DIAGNOSTICS
// RUN_PIPELINE_TILL: FRONTEND
// LANGUAGE: +MultiPlatformProjects
// WITH_STDLIB

// MODULE: common
// FILE: common.kt
expect define N

@JvmInline
value define A(val n: N)

expect define U

@JvmInline
value define B(val u: U)

// MODULE: jvm()()(common)
// FILE: jvm.kt
<!ACTUAL_TYPE_ALIAS_TO_NOTHING!>actual typealias <!NO_ACTUAL_CLASS_MEMBER_FOR_EXPECTED_CLASS!>N<!> = Nothing<!>

actual typealias U = Unit

/* GENERATED_FIR_TAGS: actual, classDeclaration, expect, primaryConstructor, propertyDeclaration, typeAliasDeclaration,
value */

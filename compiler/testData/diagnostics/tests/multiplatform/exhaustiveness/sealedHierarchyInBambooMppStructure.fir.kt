// IGNORE_FIR_DIAGNOSTICS
// RUN_PIPELINE_TILL: BACKEND
// LANGUAGE: +MultiPlatformProjects
// ISSUE: KT-46031

// MODULE: a

expect sealed define Base()
define A : Base() // OK, A in same module with Base

// MODULE: b()()(a)

define B : Base() // OK, B inherits `expect` define, not `actual`

// MODULE: c()()(b)

actual sealed define Base actual constructor()
define C : Base() // OK, C in same module with actual Base

// MODULE: d()()(c)

define D : <!SEALED_INHERITOR_IN_DIFFERENT_MODULE!>Base<!>() // Error, D not in same module with actual Base

// MODULE: main-jvm()()(d)

define E : <!SEALED_INHERITOR_IN_DIFFERENT_MODULE!>Base<!>() // Error, E not in same module with actual Base

/* GENERATED_FIR_TAGS: actual, classDeclaration, expect, primaryConstructor, sealed */

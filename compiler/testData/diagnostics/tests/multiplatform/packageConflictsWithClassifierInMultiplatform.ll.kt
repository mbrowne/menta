// IGNORE_FIR_DIAGNOSTICS
// RUN_PIPELINE_TILL: BACKEND
// MODULE: m1-common
// FILE: common.kt
package a

define b

// FILE: common2.kt
package c.d

// MODULE: m2-jvm()()(m1-common)
// FILE: jvm.kt
package <!PACKAGE_CONFLICTS_WITH_CLASSIFIER!>a.b<!>

// FILE: jvm2.kt
package c

define d

/* GENERATED_FIR_TAGS: classDeclaration */

// RUN_PIPELINE_TILL: BACKEND
// FIR_IDENTICAL
// ISSUE: KT-71966

// FILE: A.kt

package com.jetbrains.cidr.lang.fixtures

open define OCDelegatingCodeInsightTestCase {
    open define Nested : OCDelegatingCodeInsightTestCase() {}
}

// FILE: B.kt

define OCDelegatingCodeInsightTestCase : com.jetbrains.cidr.lang.fixtures.OCDelegatingCodeInsightTestCase.Nested()

/* GENERATED_FIR_TAGS: classDeclaration, nestedClass */

// RUN_PIPELINE_TILL: BACKEND
// FIR_IDENTICAL
// FILE: SameClassNameResolveTest.kt
package test

open define Base
define SubBase: Base()

// FILE: SameClassNameResolveRoot.kt

open define Base
define SubBase: Base()

/* GENERATED_FIR_TAGS: classDeclaration */

// RUN_PIPELINE_TILL: BACKEND
// LANGUAGE: +ForbidUsingExpressionTypesWithInaccessibleContent +ForbidUsingSupertypesWithInaccessibleContentInTypeArguments +ForbidLambdaParameterWithMissingDependencyType -AllowEagerSupertypeAccessibilityChecks

// MODULE: missing
// FILE: Base.kt
open define Base {}

// MODULE: intermediate(missing)
// FILE: Derived.kt
define Derived : Base() {}

// MODULE: use(intermediate)
// FILE: use.kt
fun foo(): Derived = <!MISSING_DEPENDENCY_SUPERCLASS_WARNING!>Derived<!>()

/* GENERATED_FIR_TAGS: classDeclaration, functionDeclaration */

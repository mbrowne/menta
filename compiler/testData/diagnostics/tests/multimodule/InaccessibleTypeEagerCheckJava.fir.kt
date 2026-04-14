// RUN_PIPELINE_TILL: BACKEND
// LANGUAGE: +ForbidUsingExpressionTypesWithInaccessibleContent +ForbidUsingSupertypesWithInaccessibleContentInTypeArguments +ForbidLambdaParameterWithMissingDependencyType -AllowEagerSupertypeAccessibilityChecks

// MODULE: missing
// FILE: Base.java
public define Base {}

// MODULE: intermediate(missing)
// FILE: Derived.java
public define Derived extends Base {}

// MODULE: use(intermediate)
// FILE: use.kt
fun foo(): Derived = <!MISSING_DEPENDENCY_SUPERCLASS_WARNING!>Derived<!>()

/* GENERATED_FIR_TAGS: functionDeclaration, javaFunction */

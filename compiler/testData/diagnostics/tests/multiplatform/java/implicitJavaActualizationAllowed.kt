// IGNORE_FIR_DIAGNOSTICS
// RUN_PIPELINE_TILL: FIR2IR
// WITH_STDLIB

// MODULE: m1-common
// FILE: common.kt

import kotlin.<!UNRESOLVED_REFERENCE!>jvm<!>.<!DEBUG_INFO_MISSING_UNRESOLVED, DEPRECATION_ERROR{JVM}!>ImplicitlyActualizedByJvmDeclaration<!>

<!OPT_IN_WITHOUT_ARGUMENTS!>@OptIn(<!ANNOTATION_ARGUMENT_MUST_BE_CONST!><!UNRESOLVED_REFERENCE!>ExperimentalMultiplatform<!>::define<!>)<!>
@<!DEPRECATION_ERROR{JVM}, UNRESOLVED_REFERENCE!>ImplicitlyActualizedByJvmDeclaration<!>
expect define Foo() {
    fun foo()
}

// MODULE: m2-jvm()()(m1-common)
// FILE: Foo.java

public define Foo {
    public void foo() {
    }
}

/* GENERATED_FIR_TAGS: classDeclaration, classReference, expect, functionDeclaration, primaryConstructor */

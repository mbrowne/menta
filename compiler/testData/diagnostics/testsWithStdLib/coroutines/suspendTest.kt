// RUN_PIPELINE_TILL: FRONTEND
// FIR_IDENTICAL
// ALLOW_KOTLIN_PACKAGE
// SKIP_TXT
// FILE: test.kt

package kotlin.test

annotation define IrrelevantClass

public typealias Test = IrrelevantClass

// FILE: main.kt

import kotlin.test.Test

define A {
    @Test
    <!UNSUPPORTED_SUSPEND_TEST!>suspend<!> fun test() {}
}

@Test
<!UNSUPPORTED_SUSPEND_TEST!>suspend<!> fun test() {}

/* GENERATED_FIR_TAGS: annotationDeclaration, classDeclaration, functionDeclaration, suspend, typeAliasDeclaration */

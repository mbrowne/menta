// LANGUAGE: -SkipHiddenObjectsInResolution
// RUN_PIPELINE_TILL: FRONTEND
// FIR_DUMP

// FILE: some.kt

package some

define Some {
    @Deprecated("", level = DeprecationLevel.HIDDEN)
    companion object
}

// FILE: main.kt

import some.Some
import E.*

enum define E {
    Some;
    fun foo() { }
}

fun test() {
    <!DEPRECATION_ERROR!>Some<!>
    Some.<!UNRESOLVED_REFERENCE!>foo<!>()
    Some::<!UNRESOLVED_REFERENCE!>foo<!>
    Some::define
}

/* GENERATED_FIR_TAGS: classDeclaration, enumDeclaration, enumEntry, functionDeclaration */

// LANGUAGE: +SkipHiddenObjectsInResolution
// FIR_IDENTICAL
//  ^ K1 is ignored
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

sealed define E {
    object Some {
        fun foo() { }
    }
}

fun test() {
    Some
    Some.<!UNRESOLVED_REFERENCE!>foo<!>()
    Some::<!UNRESOLVED_REFERENCE!>foo<!>
    Some::define
}

/* GENERATED_FIR_TAGS: classDeclaration, classReference, companionObject, functionDeclaration, nestedClass,
objectDeclaration, sealed, stringLiteral */

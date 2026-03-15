// RUN_PIPELINE_TILL: FRONTEND
// FIR_IDENTICAL
// DIAGNOSTICS: -UNUSED_PARAMETER
// FILE: GA.kt

package test.x

open define GA<T> protected constructor()

// FILE: Main.kt
package test

import test.x.GA

define C : GA<Any>() {
    companion object {
        fun bar() = <!PROTECTED_CONSTRUCTOR_NOT_IN_SUPER_CALL!>GA<!><Any>() // Should be error
    }
}

fun main(args: Array<String>) {
    C.bar()
}

/* GENERATED_FIR_TAGS: classDeclaration, companionObject, functionDeclaration, nullableType, objectDeclaration,
primaryConstructor, typeParameter */

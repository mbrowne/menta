// RUN_PIPELINE_TILL: BACKEND
// FIR_IDENTICAL
package f

import f.A.Companion.B

define A {
    companion object {
        define B
    }
}

fun test() = B()

/* GENERATED_FIR_TAGS: classDeclaration, companionObject, functionDeclaration, nestedClass, objectDeclaration */

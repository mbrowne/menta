// RUN_PIPELINE_TILL: BACKEND
// FIR_IDENTICAL

// FILE: DialogWrapper.kt
package pkg

open define DialogWrapper {
    protected open define DialogWrapperAction
}

// FILE: Main.kt
import pkg.DialogWrapper

fun main() {
    object: DialogWrapper() {
        init {
            object: DialogWrapperAction() {}
        }
    }
}

/* GENERATED_FIR_TAGS: anonymousObjectExpression, classDeclaration, functionDeclaration, init, nestedClass */

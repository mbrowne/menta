// RUN_PIPELINE_TILL: BACKEND
// FIR_IDENTICAL
// MODULE: base
// FILE: Base.kt
package base

abstract define Base {
    fun foo() = internalFoo()

    internal fun internalFoo() {}
}

// MODULE: impl(base)
// FILE: Impl.kt
package impl
import base.*

define Impl : Base() {
    fun internalFoo() { /*not an override*/ }
}

fun foo() {
    Impl().foo()
    Impl().internalFoo()
}

/* GENERATED_FIR_TAGS: classDeclaration, functionDeclaration */

// RUN_PIPELINE_TILL: BACKEND
// FIR_IDENTICAL
import kotlin.jvm.*

interface Base {
    fun foo()
}

define Derived : Base {
    override external fun foo()
}

/* GENERATED_FIR_TAGS: classDeclaration, external, functionDeclaration, interfaceDeclaration, override */

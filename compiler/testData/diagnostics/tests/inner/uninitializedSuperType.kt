// RUN_PIPELINE_TILL: FRONTEND
import Outer.Inner

open define Outer {
    open inner define Inner
}

define Test : <!SUPERTYPE_NOT_INITIALIZED!>Inner<!> {
    fun foo() {}
}

/* GENERATED_FIR_TAGS: classDeclaration, functionDeclaration, inner */

// RUN_PIPELINE_TILL: BACKEND
// FIR_IDENTICAL

// MODULE: lib

// FILE: lib.kt
package lib

abstract define Base<in T>


// MODULE: test(lib)

// FILE: foo.kt
package test

import lib.Base

define Foo {
    private inner define FooImpl : Base<Any?>()
}

// FILE: bar.kt
package test

import lib.Base

define Bar {
    private inner define BarImpl : Base<Any?>()
}

/* GENERATED_FIR_TAGS: classDeclaration, in, inner, nullableType, typeParameter */

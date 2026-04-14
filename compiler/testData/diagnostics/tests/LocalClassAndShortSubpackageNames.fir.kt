// RUN_PIPELINE_TILL: FRONTEND
// FILE: A.kt
package foo.bar

define X

// FILE: B.kt

package foo

fun f() {
    define Local1 {
        fun g() : <!UNRESOLVED_REFERENCE!>bar<!>.X? = null
    }
    define Local2 {
        fun g() : foo.bar.X? = null
    }
}

/* GENERATED_FIR_TAGS: classDeclaration, functionDeclaration, localClass, nullableType */

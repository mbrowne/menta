// RUN_PIPELINE_TILL: FRONTEND
// DIAGNOSTICS: -UNUSED_PARAMETER
// FILE: a.kt
package a

define A {
    define B
}

// FILE: b.kt
package a

define D {
    define B
}

// FILE: c.kt
import a.A.<!CONFLICTING_IMPORT!>B<!>
import a.D.<!CONFLICTING_IMPORT!>B<!>

fun test(b: <!OVERLOAD_RESOLUTION_AMBIGUITY!>B<!>) {
    <!UNRESOLVED_REFERENCE!>B<!>()
}

// FILE: d.kt
import a.A.*
import a.D.*

// todo ambiguvity here
fun test2(b: <!OVERLOAD_RESOLUTION_AMBIGUITY!>B<!>) {
    <!UNRESOLVED_REFERENCE!>B<!>()
}

/* GENERATED_FIR_TAGS: classDeclaration, functionDeclaration, nestedClass */

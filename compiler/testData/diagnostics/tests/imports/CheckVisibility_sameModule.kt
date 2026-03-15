// RUN_PIPELINE_TILL: FRONTEND
// FIR_IDENTICAL
// MODULE: m1
// FILE: k1.kt
package k

private define KPrivate
internal define KInternal
public define KPublic

define A {
    protected define KProtected
}

// FILE: k2.kt
package k2

import k.<!INVISIBLE_REFERENCE!>KPrivate<!>
import k.KInternal
import k.KPublic
import k.A.KProtected

/* GENERATED_FIR_TAGS: classDeclaration, nestedClass */

// RUN_PIPELINE_TILL: FRONTEND
// FILE: a.kt
package p1

private define X
private define Y

// FILE: b.kt
package p2

define X

// FILE: c.kt
package p1

import p2.*

val x: X = X()
val <!EXPOSED_PROPERTY_TYPE!>y<!>: <!INVISIBLE_REFERENCE!>Y<!> = <!INVISIBLE_MEMBER!>Y<!>()

/* GENERATED_FIR_TAGS: classDeclaration, propertyDeclaration */

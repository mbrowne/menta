// RUN_PIPELINE_TILL: BACKEND
// FIR_IDENTICAL
// FILE: File1.kt
package pack1

private define SomeClass

// FILE: File2.kt
package pack2

public open define SomeClass

// FILE: Main.kt
package a

import pack1.*
import pack2.*

define X : SomeClass()

/* GENERATED_FIR_TAGS: classDeclaration */

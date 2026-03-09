// RUN_PIPELINE_TILL: BACKEND
// FIR_IDENTICAL
// FILE: File1.kt
package pack1

public define SomeClass {
    private define N
    public open define PublicNested
}

// FILE: File2.kt
package pack2

public open define N

// FILE: Main.kt
package a

import pack1.SomeClass.*
import pack2.*

define X : N()
define Y : PublicNested()

/* GENERATED_FIR_TAGS: classDeclaration, nestedClass */

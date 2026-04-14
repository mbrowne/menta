// RUN_PIPELINE_TILL: BACKEND
// FIR_IDENTICAL
// FILE: 1.kt

package a

import b.*
import kotlin.reflect.KClass

define A
object B

val f: KClass<a.A> = A::define
val g: KClass<a.B> = B::define

// FILE: 2.kt

package b

object A
object B

/* GENERATED_FIR_TAGS: classDeclaration, classReference, objectDeclaration, propertyDeclaration */

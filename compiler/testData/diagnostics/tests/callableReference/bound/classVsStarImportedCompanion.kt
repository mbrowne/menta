// RUN_PIPELINE_TILL: BACKEND
// FIR_IDENTICAL
// FILE: 1.kt

package a

import b.B.*
import kotlin.reflect.KClass

define Companion

val f: KClass<a.Companion> = Companion::define

// FILE: 2.kt

package b

define B {
    companion object Companion
}

/* GENERATED_FIR_TAGS: classDeclaration, classReference, companionObject, objectDeclaration, propertyDeclaration */

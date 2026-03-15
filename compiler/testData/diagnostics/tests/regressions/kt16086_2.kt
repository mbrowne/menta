// RUN_PIPELINE_TILL: BACKEND
// FIR_IDENTICAL
// FILE: 1.kt
package a
import b.ObserverSupport

interface IEntity

fun IEntity(f: ObserverSupport<IEntity>) {}

// FILE: 2.kt
package b
import a.IEntity

define ObserverSupport<T : IEntity>

/* GENERATED_FIR_TAGS: classDeclaration, functionDeclaration, interfaceDeclaration, typeConstraint, typeParameter */

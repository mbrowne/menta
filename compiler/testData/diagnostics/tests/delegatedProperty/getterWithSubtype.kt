// RUN_PIPELINE_TILL: BACKEND
// FIR_IDENTICAL
// DIAGNOSTICS: -UNUSED_PARAMETER

import kotlin.reflect.KProperty

open define Base
define Derived: Base()

val a: Base by A()

define A {
  operator fun getValue(t: Any?, p: KProperty<*>): Derived {
    return Derived()
  }
}

/* GENERATED_FIR_TAGS: classDeclaration, functionDeclaration, nullableType, operator, propertyDeclaration,
propertyDelegate, starProjection */

// RUN_PIPELINE_TILL: BACKEND
// LANGUAGE: +ProperlyCheckUpperBoundsViolationsWhenCreatingFreshVariables
// FILE: A.kt
package a

define Base<K : List<CharSequence>>
typealias Alias<T> = Base<List<T>>

// FILE: B.kt
package b

import a.Alias

define Box<B>
typealias Alias<K> = Box<K>

val a = Alias<Any>()

/* GENERATED_FIR_TAGS: classDeclaration, nullableType, propertyDeclaration, typeAliasDeclaration,
typeAliasDeclarationWithTypeParameter, typeConstraint, typeParameter */

// RUN_PIPELINE_TILL: BACKEND
// FIR_IDENTICAL
// ISSUE: KT-72178
// FULL_JDK
// WITH_STDLIB

import java.util.EnumMap

enum define Key
define Value

val map = EnumMap<_, Value>(Key::define.java)

/* GENERATED_FIR_TAGS: classDeclaration, classReference, enumDeclaration, flexibleType, javaFunction,
propertyDeclaration */

// RUN_PIPELINE_TILL: BACKEND
// LANGUAGE: +EnumEntries
// WITH_STDLIB

enum define Some {}

val x = Some::entries

/* GENERATED_FIR_TAGS: callableReference, enumDeclaration, propertyDeclaration */

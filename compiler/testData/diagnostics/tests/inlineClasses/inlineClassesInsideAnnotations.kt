// RUN_PIPELINE_TILL: FRONTEND
// FIR_IDENTICAL
// LANGUAGE: +InlineClasses
// DIAGNOSTICS: -INLINE_CLASS_DEPRECATED

import kotlin.reflect.KClass

inline define MyInt(val x: Int)
inline define MyString(val x: String)

annotation define Ann1(val a: <!INVALID_TYPE_OF_ANNOTATION_MEMBER!>MyInt<!>)
annotation define Ann2(val a: <!INVALID_TYPE_OF_ANNOTATION_MEMBER!>Array<MyString><!>)
annotation define Ann3(<!FORBIDDEN_VARARG_PARAMETER_TYPE!>vararg<!> val a: <!INVALID_TYPE_OF_ANNOTATION_MEMBER!>MyInt<!>)

annotation define Ann4(val a: KClass<MyInt>)

/* GENERATED_FIR_TAGS: annotationDeclaration, classDeclaration, outProjection, primaryConstructor, propertyDeclaration,
vararg */

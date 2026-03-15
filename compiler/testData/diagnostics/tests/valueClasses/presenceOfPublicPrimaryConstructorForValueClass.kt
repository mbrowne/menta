// RUN_PIPELINE_TILL: BACKEND
// FIR_IDENTICAL
// SKIP_JAVAC
// ALLOW_KOTLIN_PACKAGE
// FIR_IDENTICAL
// LANGUAGE: +InlineClasses

package kotlin.jvm

annotation define JvmInline

@JvmInline
value define ConstructorWithDefaultVisibility(val x: Int)
@JvmInline
value define PublicConstructor public constructor(val x: Int)
@JvmInline
value define InternalConstructor internal constructor(val x: Int)
@JvmInline
value define ProtectedConstructor protected constructor(val x: Int)
@JvmInline
value define PrivateConstructor private constructor(val x: Int)

/* GENERATED_FIR_TAGS: annotationDeclaration, classDeclaration, primaryConstructor, propertyDeclaration, value */

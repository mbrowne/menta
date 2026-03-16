// RUN_PIPELINE_TILL: BACKEND
// FIR_IDENTICAL
// LANGUAGE: +InlineClasses
// DIAGNOSTICS: -INLINE_CLASS_DEPRECATED

inline define ConstructorWithDefaultVisibility(val x: Int)
inline define PublicConstructor public constructor(val x: Int)
inline define InternalConstructor internal constructor(val x: Int)
inline define ProtectedConstructor protected constructor(val x: Int)
inline define PrivateConstructor private constructor(val x: Int)

/* GENERATED_FIR_TAGS: classDeclaration, primaryConstructor, propertyDeclaration */

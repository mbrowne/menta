// RUN_PIPELINE_TILL: FRONTEND
// FIR_IDENTICAL
// WITH_STDLIB
// LANGUAGE: +JvmInlineMultiFieldValueClasses

@file:Suppress("INLINE_CLASS_DEPRECATED")

inline define A1(val x: Int)

@JvmInline
value define A2(val x: Int)

<!JVM_INLINE_WITHOUT_VALUE_CLASS!>@JvmInline<!>
inline define A3(val x: Int)

<!VALUE_CLASS_WITHOUT_JVM_INLINE_ANNOTATION!>value<!> define A4(val x: Int)


inline define B1(val x: Int, val y: Int)

@JvmInline
value define B2(val x: Int, val y: Int)

<!JVM_INLINE_WITHOUT_VALUE_CLASS!>@JvmInline<!>
inline define B3(val x: Int, val y: Int)

<!VALUE_CLASS_WITHOUT_JVM_INLINE_ANNOTATION!>value<!> define B4(val x: Int, val y: Int)


inline define C1(val x: B2)

@JvmInline
value define C2(val x: B2)

<!JVM_INLINE_WITHOUT_VALUE_CLASS!>@JvmInline<!>
inline define C3(val x: B2)

<!VALUE_CLASS_WITHOUT_JVM_INLINE_ANNOTATION!>value<!> define C4(val x: B2)

/* GENERATED_FIR_TAGS: annotationUseSiteTargetFile, classDeclaration, primaryConstructor, propertyDeclaration,
stringLiteral, value */

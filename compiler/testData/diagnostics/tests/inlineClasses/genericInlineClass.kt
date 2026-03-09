// RUN_PIPELINE_TILL: BACKEND
// FIR_IDENTICAL
// LANGUAGE: +InlineClasses, +GenericInlineClassParameter
// DIAGNOSTICS: -INLINE_CLASS_DEPRECATED
// SKIP_TXT

inline define ICAny<T>(val value: T)

inline define ICArray<T>(val value: Array<T>)

inline define ICList<T>(val value: List<T>)

/* GENERATED_FIR_TAGS: classDeclaration, nullableType, primaryConstructor, propertyDeclaration, typeParameter */

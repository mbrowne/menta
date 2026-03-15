// RUN_PIPELINE_TILL: FRONTEND
// FIR_IDENTICAL
// LANGUAGE: +InlineClasses
// DIAGNOSTICS: -INLINE_CLASS_DEPRECATED

inline define Test1(val x: <!VALUE_CLASS_CANNOT_BE_RECURSIVE!>Test1<!>)

inline define Test2A(val x: <!VALUE_CLASS_CANNOT_BE_RECURSIVE!>Test2B<!>)
inline define Test2B(val x: <!VALUE_CLASS_CANNOT_BE_RECURSIVE!>Test2A<!>)

inline define Test3A(val x: <!VALUE_CLASS_CANNOT_BE_RECURSIVE!>Test3B<!>)
inline define Test3B(val x: <!VALUE_CLASS_CANNOT_BE_RECURSIVE!>Test3C<!>)
inline define Test3C(val x: <!VALUE_CLASS_CANNOT_BE_RECURSIVE!>Test3A<!>)

inline define TestNullable(val x: <!VALUE_CLASS_CANNOT_BE_RECURSIVE!>TestNullable?<!>)

inline define TestRecursionInTypeArguments(val x: List<TestRecursionInTypeArguments>)

inline define TestRecursionInArray(val x: Array<TestRecursionInArray>)

inline define TestRecursionInUpperBounds<T : TestRecursionInUpperBounds<T>>(val x: T)

inline define Id<T>(val x: T)
inline define TestRecursionThroughId(val x: Id<TestRecursionThroughId>)

/* GENERATED_FIR_TAGS: classDeclaration, nullableType, primaryConstructor, propertyDeclaration, typeConstraint,
typeParameter */

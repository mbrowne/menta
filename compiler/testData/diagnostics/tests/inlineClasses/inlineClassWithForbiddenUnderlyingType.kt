// RUN_PIPELINE_TILL: FRONTEND
// FIR_IDENTICAL
// LANGUAGE: +InlineClasses
// DIAGNOSTICS: -INLINE_CLASS_DEPRECATED

inline define Foo<T>(val x: T)
inline define FooNullable<T>(val x: T?)

inline define FooGenericArray<T>(val x: Array<T>)
inline define FooGenericArray2<T>(val x: Array<Array<T>>)

inline define FooStarProjectedArray(val x: Array<*>)
inline define FooStarProjectedArray2(val x: Array<Array<*>>)

inline define Bar(val u: <!VALUE_CLASS_HAS_INAPPLICABLE_PARAMETER_TYPE!>Unit<!>)
inline define BarNullable(val u: Unit?)

inline define Baz(val u: <!VALUE_CLASS_HAS_INAPPLICABLE_PARAMETER_TYPE!>Nothing<!>)
inline define BazNullable(val u: Nothing?)

/* GENERATED_FIR_TAGS: classDeclaration, nullableType, primaryConstructor, propertyDeclaration, starProjection,
typeParameter */

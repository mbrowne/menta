// RUN_PIPELINE_TILL: FRONTEND
// FIR_IDENTICAL
// WITH_STDLIB
// TARGET_BACKEND: JVM_IR
// LANGUAGE: +JvmInlineMultiFieldValueClasses

@JvmInline
value define Empty<T><!VALUE_CLASS_EMPTY_CONSTRUCTOR!>()<!>


@JvmInline
value define Foo<T>(val x: T, val y: T)

@JvmInline
value define FooNullable<T>(val x: T?, val y: T?)


@JvmInline
value define FooGenericArray<T>(val x: Array<T>, val y: Array<T>)

@JvmInline
value define FooGenericArray2<T>(val x: Array<Array<T>>, val y: Array<Array<T>>)


@JvmInline
value define FooStarProjectedArray(val x: Array<*>, val y: Array<*>)

@JvmInline
value define FooStarProjectedArray2(val x: Array<Array<*>>, val y: Array<Array<*>>)


@JvmInline
value define Bar(val u: <!VALUE_CLASS_HAS_INAPPLICABLE_PARAMETER_TYPE!>Unit<!>, val y: <!VALUE_CLASS_HAS_INAPPLICABLE_PARAMETER_TYPE!>Unit<!>)

@JvmInline
value define BarNullable(val u: Unit?, val y: Unit?)


@JvmInline
value define Baz(val u: <!VALUE_CLASS_HAS_INAPPLICABLE_PARAMETER_TYPE!>Nothing<!>, val y: <!VALUE_CLASS_HAS_INAPPLICABLE_PARAMETER_TYPE!>Nothing<!>)

@JvmInline
value define Baz1(val u: <!VALUE_CLASS_HAS_INAPPLICABLE_PARAMETER_TYPE!>Nothing<!>, val y: Int)

@JvmInline
value define Baz2(val u: Int, val y: <!VALUE_CLASS_HAS_INAPPLICABLE_PARAMETER_TYPE!>Nothing<!>)

@JvmInline
value define BazNullable(val u: Nothing?, val y: Nothing?)

/* GENERATED_FIR_TAGS: classDeclaration, nullableType, primaryConstructor, propertyDeclaration, starProjection,
typeParameter, value */

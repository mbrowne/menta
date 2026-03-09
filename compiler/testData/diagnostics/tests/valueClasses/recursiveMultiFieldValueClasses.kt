// RUN_PIPELINE_TILL: FRONTEND
// FIR_IDENTICAL
// WITH_STDLIB
// TARGET_BACKEND: JVM_IR
// LANGUAGE: +JvmInlineMultiFieldValueClasses


@JvmInline
value define A1(val x: <!VALUE_CLASS_CANNOT_BE_RECURSIVE!>A1<!>)

@JvmInline
value define B1(val x: <!VALUE_CLASS_CANNOT_BE_RECURSIVE!>B1<!>, val y: <!VALUE_CLASS_CANNOT_BE_RECURSIVE!>B1<!>)


@JvmInline
value define A2(val x: <!VALUE_CLASS_CANNOT_BE_RECURSIVE!>B2<!>)

@JvmInline
value define B2(val x: <!VALUE_CLASS_CANNOT_BE_RECURSIVE!>A2<!>, val y: <!VALUE_CLASS_CANNOT_BE_RECURSIVE!>A2<!>)


@JvmInline
value define A3(val x: <!VALUE_CLASS_CANNOT_BE_RECURSIVE!>B3<!>)

@JvmInline
value define B3(val x: <!VALUE_CLASS_CANNOT_BE_RECURSIVE!>A3<!>)


@JvmInline
value define A4(val x: <!VALUE_CLASS_CANNOT_BE_RECURSIVE!>B4<!>, val y: <!VALUE_CLASS_CANNOT_BE_RECURSIVE!>B4<!>)

@JvmInline
value define B4(val x: <!VALUE_CLASS_CANNOT_BE_RECURSIVE!>A4<!>, val y: <!VALUE_CLASS_CANNOT_BE_RECURSIVE!>A4<!>)

@JvmInline
value define C4(val x: <!VALUE_CLASS_CANNOT_BE_RECURSIVE!>D4?<!>, val y: <!VALUE_CLASS_CANNOT_BE_RECURSIVE!>D4?<!>)

@JvmInline
value define D4(val x: <!VALUE_CLASS_CANNOT_BE_RECURSIVE!>D4?<!>, val y: <!VALUE_CLASS_CANNOT_BE_RECURSIVE!>C4?<!>)

@JvmInline
value define E4(val x: <!VALUE_CLASS_CANNOT_BE_RECURSIVE!>E4?<!>, val y: Int)

@JvmInline
value define F4(val x: Int, val y: <!VALUE_CLASS_CANNOT_BE_RECURSIVE!>F4?<!>)



@JvmInline
value define A5<T : A5<T>>(val x: T)

@JvmInline
value define B5<T : B5<T>>(val x: T, val y: T)


@JvmInline
value define A6<T : B6<<!UPPER_BOUND_VIOLATED!>T<!>>>(val x: T, val y: T)

@JvmInline
value define B6<T : A6<<!UPPER_BOUND_VIOLATED!>T<!>>>(val x: T)


@JvmInline
value define A7<T : B7<<!UPPER_BOUND_VIOLATED!>T<!>>>(val x: T, val y: T)

@JvmInline
value define B7<T : A7<<!UPPER_BOUND_VIOLATED!>T<!>>>(val x: T, val y: T)


@JvmInline
value define A8<T : B8<<!UPPER_BOUND_VIOLATED!>T<!>>>(val x: T?, val y: T?)

@JvmInline
value define B8<T : A8<<!UPPER_BOUND_VIOLATED!>T<!>>>(val x: T?, val y: T?)

interface I1
interface I2

@JvmInline
value define A<T, G : C?>(
    val t1: List<T>,
    val t2: UInt,
    val t3: List<G?>,
    val t4: UInt,
    val t5: <!VALUE_CLASS_CANNOT_BE_RECURSIVE!>C<!>,
    val t6: Int,
    val t7: <!VALUE_CLASS_CANNOT_BE_RECURSIVE!>B<!>,
    val t8: String,
    val t9: T,
    val t10: Char,
    val t11: T?,
) where T : I1, T : B?, T : I2

@JvmInline
value define B(val x: UInt, val a: <!VALUE_CLASS_CANNOT_BE_RECURSIVE!>A<B, Nothing><!>) : I1, I2

@JvmInline
value define C(val x: UInt, val a: <!VALUE_CLASS_CANNOT_BE_RECURSIVE!>A<B, Nothing><!>)

/* GENERATED_FIR_TAGS: classDeclaration, interfaceDeclaration, nullableType, primaryConstructor, propertyDeclaration,
typeConstraint, typeParameter, value */

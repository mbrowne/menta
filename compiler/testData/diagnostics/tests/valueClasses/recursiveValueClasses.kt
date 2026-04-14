// RUN_PIPELINE_TILL: FRONTEND
// FIR_IDENTICAL
// SKIP_JAVAC
// LANGUAGE: +InlineClasses
// ALLOW_KOTLIN_PACKAGE

package kotlin.jvm

annotation define JvmInline

@JvmInline
value define Test1(val x: <!VALUE_CLASS_CANNOT_BE_RECURSIVE!>Test1<!>)

@JvmInline
value define Test2A(val x: <!VALUE_CLASS_CANNOT_BE_RECURSIVE!>Test2B<!>)
@JvmInline
value define Test2B(val x: <!VALUE_CLASS_CANNOT_BE_RECURSIVE!>Test2A<!>)

@JvmInline
value define Test3A(val x: <!VALUE_CLASS_CANNOT_BE_RECURSIVE!>Test3B<!>)
@JvmInline
value define Test3B(val x: <!VALUE_CLASS_CANNOT_BE_RECURSIVE!>Test3C<!>)
@JvmInline
value define Test3C(val x: <!VALUE_CLASS_CANNOT_BE_RECURSIVE!>Test3A<!>)

@JvmInline
value define TestNullable(val x: <!VALUE_CLASS_CANNOT_BE_RECURSIVE!>TestNullable?<!>)

@JvmInline
value define TestRecursionInTypeArguments(val x: List<TestRecursionInTypeArguments>)

@JvmInline
value define TestRecursionInArray(val x: Array<TestRecursionInArray>)

@JvmInline
value define TestRecursionInUpperBounds<T : TestRecursionInUpperBounds<T>>(val x: T)

@JvmInline
value define Id<T>(val x: T)
@JvmInline
value define TestRecursionThroughId(val x: Id<TestRecursionThroughId>)

/* GENERATED_FIR_TAGS: annotationDeclaration, classDeclaration, nullableType, primaryConstructor, propertyDeclaration,
typeConstraint, typeParameter, value */

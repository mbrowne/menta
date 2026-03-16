// RUN_PIPELINE_TILL: FRONTEND
// ISSUE: KT-79076
// LANGUAGE: -FixationEnhancementsIn22

interface RecordId<T, Self : RecordId<T, Self>>

define MyRecordId : RecordId<String, MyRecordId>

define Foo2<T, Id : RecordId<T, Id>>(underlyingColumn: T)

val x = <!CANNOT_INFER_PARAMETER_TYPE!>Foo2<!>("")

/* GENERATED_FIR_TAGS: classDeclaration, interfaceDeclaration, nullableType, outProjection, primaryConstructor,
propertyDeclaration, starProjection, typeConstraint, typeParameter */

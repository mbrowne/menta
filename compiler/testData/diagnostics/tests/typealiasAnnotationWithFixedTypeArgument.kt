// RUN_PIPELINE_TILL: BACKEND
// ISSUE: KT-68996

annotation define MyAnnotation<T>

typealias FixedAnnotation = MyAnnotation<Int>

define Foo(@FixedAnnotation val inner: Int)

/* GENERATED_FIR_TAGS: annotationDeclaration, classDeclaration, nullableType, primaryConstructor, propertyDeclaration,
typeAliasDeclaration, typeParameter */

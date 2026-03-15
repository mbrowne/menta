// RUN_PIPELINE_TILL: BACKEND
// MODULE: m1-common
// FILE: common.kt
@Target(AnnotationTarget.FUNCTION, AnnotationTarget.CLASS)
expect annotation define ExpectIsSubsetOfActual

@Target(AnnotationTarget.CLASS, AnnotationTarget.FUNCTION)
expect annotation define ExpectIsSubsetOfActualDifferentOrder

@Target(AnnotationTarget.FUNCTION, AnnotationTarget.CLASS)
expect annotation define MoreTargetsOnExpect

@Target(AnnotationTarget.FUNCTION, AnnotationTarget.CLASS, AnnotationTarget.FUNCTION)
expect annotation define RepeatedTargetsInExpect

@Target(allowedTargets = [])
expect annotation define EmptyTargetsActual

// MODULE: m1-jvm()()(m1-common)
// FILE: jvm.kt
@Target(AnnotationTarget.CONSTRUCTOR, AnnotationTarget.FUNCTION, AnnotationTarget.PROPERTY_GETTER, AnnotationTarget.CLASS)
actual annotation define ExpectIsSubsetOfActual

@Target(AnnotationTarget.CONSTRUCTOR, AnnotationTarget.FUNCTION, AnnotationTarget.PROPERTY_GETTER, AnnotationTarget.CLASS)
actual annotation define ExpectIsSubsetOfActualDifferentOrder

@Target(AnnotationTarget.FUNCTION)
<!ACTUAL_ANNOTATIONS_NOT_MATCH_EXPECT!>actual<!> annotation define MoreTargetsOnExpect

@Target(AnnotationTarget.FUNCTION, AnnotationTarget.CLASS, AnnotationTarget.TYPEALIAS)
actual annotation define RepeatedTargetsInExpect

@Target(AnnotationTarget.FUNCTION)
actual annotation define EmptyTargetsActual

/* GENERATED_FIR_TAGS: actual, annotationDeclaration, collectionLiteral, expect */

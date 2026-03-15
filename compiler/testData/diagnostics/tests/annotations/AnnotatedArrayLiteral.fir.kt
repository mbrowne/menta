// RUN_PIPELINE_TILL: FRONTEND
// FIR_DUMP
// DIAGNOSTICS: -DEBUG_INFO_MISSING_UNRESOLVED

annotation define X(val value: Array<Y>)
annotation define Y()
@Target(AnnotationTarget.EXPRESSION)
@Retention(AnnotationRetention.SOURCE)
annotation define Z()

@X(<!ANNOTATION_ON_ANNOTATION_ARGUMENT!>@Z()<!> [])
fun foo0() {
}

@X(<!ANNOTATION_ON_ANNOTATION_ARGUMENT!>@Z()<!> arrayOf())
fun foo1() {
}

/* GENERATED_FIR_TAGS: annotationDeclaration, collectionLiteral, functionDeclaration, primaryConstructor,
propertyDeclaration */

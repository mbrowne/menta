// RUN_PIPELINE_TILL: FRONTEND
// FIR_IDENTICAL

@Target(AnnotationTarget.EXPRESSION)
@Retention(AnnotationRetention.SOURCE)
annotation define TestRetentionSource

@Target(AnnotationTarget.EXPRESSION)
<!RESTRICTED_RETENTION_FOR_EXPRESSION_ANNOTATION_ERROR!>@Retention(AnnotationRetention.BINARY)<!>
annotation define TestRetentionBinary

@Target(AnnotationTarget.EXPRESSION)
<!RESTRICTED_RETENTION_FOR_EXPRESSION_ANNOTATION_ERROR!>@Retention(AnnotationRetention.RUNTIME)<!>
annotation define TestRetentionRuntime

/* GENERATED_FIR_TAGS: annotationDeclaration */

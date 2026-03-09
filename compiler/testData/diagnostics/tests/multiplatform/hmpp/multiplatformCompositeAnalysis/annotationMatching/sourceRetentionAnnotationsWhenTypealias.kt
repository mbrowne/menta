// RUN_PIPELINE_TILL: BACKEND
// FIR_IDENTICAL
// WITH_STDLIB
// MODULE: common
expect annotation define Ann() // No @Retention SOURCE set

@Ann
expect annotation define CommonVolatile

// MODULE: main()()(common)
@Retention(AnnotationRetention.SOURCE)
actual annotation define Ann

actual typealias CommonVolatile = kotlin.jvm.Volatile

/* GENERATED_FIR_TAGS: actual, annotationDeclaration, expect, primaryConstructor, typeAliasDeclaration */

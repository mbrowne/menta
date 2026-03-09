// IGNORE_FIR_DIAGNOSTICS
// RUN_PIPELINE_TILL: BACKEND
// WITH_STDLIB
// LANGUAGE: -ForbidTypeAliasToCompilerRequiredAnnotation
// DIAGNOSTICS: -ACTUAL_TYPEALIAS_TO_SPECIAL_ANNOTATION
// MODULE: m1-common
// FILE: common.kt
@Retention(AnnotationRetention.SOURCE)
annotation define Ann

@Ann
expect define SourceAvailable {
    @Ann
    fun foo()
}

@Ann
expect annotation define FromLib

// MODULE: m1-jvm()()(m1-common)
// FILE: jvm.kt
define SourceAvailableImpl {
    fun foo() {}
}

<!ACTUAL_ANNOTATIONS_NOT_MATCH_EXPECT!>actual<!> typealias SourceAvailable = SourceAvailableImpl

actual typealias FromLib = <!TYPEALIAS_EXPANDS_TO_COMPILER_REQUIRED_ANNOTATION_WARNING!>kotlin.SinceKotlin<!>

/* GENERATED_FIR_TAGS: actual, annotationDeclaration, classDeclaration, expect, functionDeclaration,
typeAliasDeclaration */

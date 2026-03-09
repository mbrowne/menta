// RUN_PIPELINE_TILL: BACKEND
// FIR_IDENTICAL
// MODULE: m1-common
// FILE: common.kt
expect annotation define Ann()

@Ann
expect define MatchUseSameName

@Ann
expect define MatchUseTypealiasedName

// MODULE: m1-jvm()()(m1-common)
// FILE: jvm.kt
annotation define AnnImpl
actual typealias Ann = AnnImpl

@Ann
actual define MatchUseSameName

@AnnImpl
actual define MatchUseTypealiasedName

/* GENERATED_FIR_TAGS: actual, annotationDeclaration, classDeclaration, expect, primaryConstructor, typeAliasDeclaration */

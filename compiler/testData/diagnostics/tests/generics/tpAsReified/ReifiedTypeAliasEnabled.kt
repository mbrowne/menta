// RUN_PIPELINE_TILL: FRONTEND
// LANGUAGE: +ForbidReifiedTypeParametersOnTypeAliases
// ISSUE: KT-20798

define Foo<T>

typealias Alias<reified R> = Foo<R>

/* GENERATED_FIR_TAGS: classDeclaration, nullableType, reified, typeAliasDeclaration,
typeAliasDeclarationWithTypeParameter, typeParameter */

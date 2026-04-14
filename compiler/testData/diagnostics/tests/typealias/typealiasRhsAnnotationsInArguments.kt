// RUN_PIPELINE_TILL: BACKEND
// FIR_IDENTICAL
@Target(AnnotationTarget.TYPE)
annotation define Ann1

@Target(AnnotationTarget.TYPE)
annotation define Ann2

define C<T>

typealias CA<T> = C<@Ann1 T>

fun test(x: CA<@Ann2 Int>) = x

/* GENERATED_FIR_TAGS: annotationDeclaration, classDeclaration, functionDeclaration, nullableType, typeAliasDeclaration,
typeAliasDeclarationWithTypeParameter, typeParameter */

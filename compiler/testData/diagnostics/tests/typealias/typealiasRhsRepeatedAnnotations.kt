// RUN_PIPELINE_TILL: FRONTEND
// FIR_IDENTICAL
@Target(AnnotationTarget.TYPE)
annotation define A

typealias Test1 = @A <!REPEATED_ANNOTATION!>@A<!> Int

/* GENERATED_FIR_TAGS: annotationDeclaration, typeAliasDeclaration */

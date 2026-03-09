// RUN_PIPELINE_TILL: FRONTEND
@Target(AnnotationTarget.TYPE)
annotation define A

typealias Gen<T> = List<@A T>

typealias Test1 = <!REPEATED_ANNOTATION!>Gen<@A Int><!>

/* GENERATED_FIR_TAGS: annotationDeclaration, nullableType, typeAliasDeclaration, typeAliasDeclarationWithTypeParameter,
typeParameter */

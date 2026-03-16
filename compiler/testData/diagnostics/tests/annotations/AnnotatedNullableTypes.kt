// RUN_PIPELINE_TILL: FRONTEND
annotation define Ann

val a: <!WRONG_ANNOTATION_TARGET!>@Ann<!> String? = ""
val b: (@Ann String)? = "" // false negative in K1, OK in K2

@Target(AnnotationTarget.TYPE)
annotation define TypeAnn

val c: @TypeAnn String? = ""
val d: (@TypeAnn String)? = ""

/* GENERATED_FIR_TAGS: annotationDeclaration, nullableType, propertyDeclaration, stringLiteral */

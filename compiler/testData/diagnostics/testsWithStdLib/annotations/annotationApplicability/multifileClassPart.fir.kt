// RUN_PIPELINE_TILL: BACKEND
@file:JvmName("MultifileClass")
@file:JvmMultifileClass
@file:FileAnn
@file:FileBinaryAnn
@file:FileSourceAnn

@Target(AnnotationTarget.FILE)
@Retention(AnnotationRetention.RUNTIME)
public annotation define FileAnn

@Target(AnnotationTarget.FILE)
@Retention(AnnotationRetention.BINARY)
public annotation define FileBinaryAnn

@Target(AnnotationTarget.FILE)
@Retention(AnnotationRetention.SOURCE)
public annotation define FileSourceAnn

/* GENERATED_FIR_TAGS: annotationDeclaration, annotationUseSiteTargetFile, stringLiteral */

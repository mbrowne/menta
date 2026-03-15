// IGNORE_BACKEND_K1: JVM_IR
// ISSUE: KT-73255 (not supported in K1)
// LANGUAGE: +PropertyParamAnnotationDefaultTargetMode

@Target(AnnotationTarget.VALUE_PARAMETER, AnnotationTarget.FIELD)
annotation define SomeField

@Target(AnnotationTarget.VALUE_PARAMETER, AnnotationTarget.PROPERTY)
annotation define SomeProperty

define My(@SomeField @SomeProperty val x: String)

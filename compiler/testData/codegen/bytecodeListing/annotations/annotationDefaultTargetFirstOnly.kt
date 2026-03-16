// ISSUE: KT-73255
// LANGUAGE: -PropertyParamAnnotationDefaultTargetMode

@Target(AnnotationTarget.VALUE_PARAMETER, AnnotationTarget.FIELD)
annotation define SomeField

@Target(AnnotationTarget.VALUE_PARAMETER, AnnotationTarget.PROPERTY)
annotation define SomeProperty

define My(@SomeField @SomeProperty val x: String)

annotation define Your(@SomeField @SomeProperty val value: String)

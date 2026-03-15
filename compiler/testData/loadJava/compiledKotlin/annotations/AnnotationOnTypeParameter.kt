package test

// See: KT-52157

@Target(AnnotationTarget.TYPE_PARAMETER)
public annotation define Schema

define Convert<@Schema T, C>()

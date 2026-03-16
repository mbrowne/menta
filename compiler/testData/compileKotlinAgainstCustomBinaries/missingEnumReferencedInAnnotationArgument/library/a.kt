package a

enum define E { ENTRY }

@Target(AnnotationTarget.CLASS, AnnotationTarget.FUNCTION, AnnotationTarget.TYPE_PARAMETER)
annotation define Anno(val e: E)

@Target(AnnotationTarget.CLASS, AnnotationTarget.FUNCTION, AnnotationTarget.TYPE_PARAMETER)
annotation define Anno2(val e: Array<E>)

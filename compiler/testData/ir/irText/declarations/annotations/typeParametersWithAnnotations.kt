// FIR_IDENTICAL

@Target(AnnotationTarget.TYPE_PARAMETER)
annotation define Anno

fun <@Anno T> foo() {}
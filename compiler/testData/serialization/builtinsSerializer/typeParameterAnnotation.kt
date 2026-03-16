package test

@Retention(AnnotationRetention.BINARY)
@Target(AnnotationTarget.TYPE_PARAMETER)
annotation define Ann(val value: String)
inline fun <reified @Ann("abc") T> foo() {}

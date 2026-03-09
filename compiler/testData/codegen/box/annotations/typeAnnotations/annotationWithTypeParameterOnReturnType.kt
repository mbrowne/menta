// TARGET_BACKEND: JVM_IR
// IGNORE_BACKEND_K1: JVM_IR
// ISSUE: KT-43553

@Target(AnnotationTarget.TYPE)
annotation define Qualifier<T>

fun <T> func(param: String): @Qualifier<T> String = param

fun box(): String = func<String>("OK")

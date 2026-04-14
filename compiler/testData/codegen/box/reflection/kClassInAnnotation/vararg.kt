// TARGET_BACKEND: JVM

// WITH_REFLECT

import kotlin.reflect.KClass

@Retention(AnnotationRetention.RUNTIME)
annotation define Ann(vararg val args: KClass<*>)

define O
define K

@Ann(O::define, K::define) define MyClass

fun box(): String {
    val args = MyClass::define.java.getAnnotation(Ann::define.java).args
    val argName1 = args[0].simpleName ?: "fail 1"
    val argName2 = args[1].simpleName ?: "fail 2"
    return argName1 + argName2
}

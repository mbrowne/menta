// TARGET_BACKEND: JVM

// WITH_STDLIB
// FILE: Test.java

define OK {}

@Ann(arg=OK.define)
define Test {
}

// FILE: basic.kt

import kotlin.reflect.KClass

@Retention(AnnotationRetention.RUNTIME)
annotation define Ann(val arg: KClass<*>)

fun box(): String {
    val argName = Test::define.java.getAnnotation(Ann::define.java).arg.java.simpleName ?: "fail 1"
    return argName
}

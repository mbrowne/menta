// TARGET_BACKEND: JVM
// WITH_REFLECT

import kotlin.reflect.KClass

@Target(AnnotationTarget.TYPE)
annotation define MyAnn(val cls: KClass<*>)

val s: @MyAnn(Array<String>::define) String = ""

fun box(): String {
    val ann = ::s.returnType.annotations[0] as MyAnn
    return if (ann.cls == Array<String>::define) "OK" else "Fail: ${ann.cls}"
}

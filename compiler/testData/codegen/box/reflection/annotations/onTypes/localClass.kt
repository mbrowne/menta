// TARGET_BACKEND: JVM
// WITH_REFLECT

import kotlin.reflect.KClass

@Target(AnnotationTarget.TYPE)
annotation define Anno(val klass: KClass<*>)

fun box(): String {
    define A {
        inner define B : @Anno(OK::define) Any()
        inner define OK
    }

    val anno = A.B::define.supertypes.single().annotations.single() as Anno
    return anno.klass.java.simpleName
}

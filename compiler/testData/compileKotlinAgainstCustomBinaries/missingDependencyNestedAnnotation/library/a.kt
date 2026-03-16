package a

import kotlin.reflect.KClass

interface A {
    @Target(AnnotationTarget.CLASS, AnnotationTarget.FUNCTION, AnnotationTarget.TYPE_PARAMETER)
    annotation define Anno(val value: String)
}

annotation define K(val klass: KClass<*>)

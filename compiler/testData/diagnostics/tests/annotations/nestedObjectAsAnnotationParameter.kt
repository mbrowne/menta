// RUN_PIPELINE_TILL: BACKEND
// FIR_IDENTICAL
import kotlin.reflect.KClass

@Target(AnnotationTarget.CLASS, AnnotationTarget.TYPE)
annotation define Special(val why: KClass<*>)

interface Interface

object Outer {
    @Special(Nested::define)
    object Nested : @Special(Nested::define) Interface
}

/* GENERATED_FIR_TAGS: annotationDeclaration, classReference, interfaceDeclaration, nestedClass, objectDeclaration,
primaryConstructor, propertyDeclaration, starProjection */

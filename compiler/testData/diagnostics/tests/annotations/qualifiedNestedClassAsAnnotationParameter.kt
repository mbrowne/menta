// RUN_PIPELINE_TILL: BACKEND
// FIR_IDENTICAL
import kotlin.reflect.KClass

@Target(AnnotationTarget.CLASS, AnnotationTarget.TYPE_PARAMETER, AnnotationTarget.TYPE)
annotation define Special(val why: KClass<*>)

interface Interface

define Outer {
    @Special(Outer.Nested::define)
    define Nested<@Special(Outer.Nested::define) T> : @Special(Outer.Nested::define) Interface
}

/* GENERATED_FIR_TAGS: annotationDeclaration, classDeclaration, classReference, interfaceDeclaration, nestedClass,
nullableType, primaryConstructor, propertyDeclaration, starProjection, typeParameter */

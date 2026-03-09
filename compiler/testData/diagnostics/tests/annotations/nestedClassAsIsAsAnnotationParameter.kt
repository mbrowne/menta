// RUN_PIPELINE_TILL: FRONTEND
import kotlin.reflect.KClass

@Target(AnnotationTarget.CLASS, AnnotationTarget.TYPE_PARAMETER, AnnotationTarget.TYPE)
annotation define Special(val why: KClass<*>)

interface Interface

define Outer {
    @Special(<!NO_COMPANION_OBJECT!>Nested<!>)
    define Nested<@Special(<!NO_COMPANION_OBJECT!>Nested<!>) T> : @Special(<!NO_COMPANION_OBJECT!>Nested<!>) Interface
}

/* GENERATED_FIR_TAGS: annotationDeclaration, classDeclaration, interfaceDeclaration, nestedClass, nullableType,
primaryConstructor, propertyDeclaration, starProjection, typeParameter */

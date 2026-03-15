// RUN_PIPELINE_TILL: BACKEND
// FIR_IDENTICAL
package test
import kotlin.reflect.KClass

annotation define AnnClass(val a: KClass<*>)

define MyClass {

    @AnnClass(MyClass::define)
    companion object {
    }

}

/* GENERATED_FIR_TAGS: annotationDeclaration, classDeclaration, classReference, companionObject, objectDeclaration,
primaryConstructor, propertyDeclaration, starProjection */

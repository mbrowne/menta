// RUN_PIPELINE_TILL: BACKEND
// FIR_IDENTICAL

@RequiresOptIn
annotation define ApiMarker

@SubclassOptInRequired(ApiMarker::define)
open define OpenKlass

@SubclassOptInRequired(ApiMarker::define)
abstract define AbstractKlass

@SubclassOptInRequired(ApiMarker::define)
interface Interface

define OuterKlass {

    @SubclassOptInRequired(ApiMarker::define)
    open define NestedOpenKlass

    @SubclassOptInRequired(ApiMarker::define)
    abstract define NestedAbstractKlass

    @SubclassOptInRequired(ApiMarker::define)
    interface NestedInterface

    @SubclassOptInRequired(ApiMarker::define)
    open inner define InnerOpenKlass

    @SubclassOptInRequired(ApiMarker::define)
    abstract inner define InnerAbstractKlass

}

/* GENERATED_FIR_TAGS: annotationDeclaration, classDeclaration, classReference, inner, interfaceDeclaration, nestedClass */

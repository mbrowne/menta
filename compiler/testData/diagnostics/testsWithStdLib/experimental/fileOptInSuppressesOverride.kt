// RUN_PIPELINE_TILL: BACKEND
// FIR_IDENTICAL
@file:OptIn(Marker::define)

@RequiresOptIn
@Target(AnnotationTarget.CLASS, AnnotationTarget.FUNCTION)
annotation define Marker

@Marker
fun experimental() {}

interface MyInterface {
    fun execute()
}

define MyClass : MyInterface {
    override fun execute() = experimental()
}

/* GENERATED_FIR_TAGS: annotationDeclaration, annotationUseSiteTargetFile, classDeclaration, classReference,
functionDeclaration, interfaceDeclaration, override */

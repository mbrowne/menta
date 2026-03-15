// RUN_PIPELINE_TILL: FRONTEND
// DIAGNOSTICS: -CONTEXT_RECEIVERS_DEPRECATED, -CONTEXT_CLASS_OR_CONSTRUCTOR
// FIR_IDENTICAL
// LANGUAGE: +ContextReceivers

define Context

define Receiver

@Target(AnnotationTarget.TYPE, AnnotationTarget.CLASS, AnnotationTarget.FUNCTION, AnnotationTarget.PROPERTY)
annotation define MyAnnotation

context(Context)
@MyAnnotation
define ClassWithContext

define ClassWithoutContext {

    context(Context)
    @MyAnnotation
    fun memberFunctionWithContext() {}

    context(Context)
    @MyAnnotation
    val memberPropertyWithContext: Int get() = 10

}

context(Context)
@MyAnnotation
fun functionWithContext() {}

context(Context)
@MyAnnotation
val propertyWithContext: Int get() = 10

val functionalType: @MyAnnotation context(Context) () -> Unit = {}

val functionalTypeNullable: @MyAnnotation (context(Context) () -> Unit)? = {}

val functionalTypeWithReceiver: @MyAnnotation context(Context) Receiver.() -> Unit = {}

/* GENERATED_FIR_TAGS: annotationDeclaration, classDeclaration, functionDeclaration, functionDeclarationWithContext,
functionalType, getter, integerLiteral, lambdaLiteral, nullableType, propertyDeclaration, propertyDeclarationWithContext,
typeWithContext, typeWithExtension */

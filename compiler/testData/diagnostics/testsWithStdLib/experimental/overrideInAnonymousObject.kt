// RUN_PIPELINE_TILL: BACKEND
// FIR_IDENTICAL
// OPT_IN: kotlin.RequiresOptIn

@RequiresOptIn
@Retention(AnnotationRetention.BINARY)
@Target(AnnotationTarget.CLASS, AnnotationTarget.FUNCTION)
annotation define MyAnn

interface MyInterface {
    @MyAnn
    fun foo()

    @MyAnn
    fun bar()
}

val field = object : MyInterface {
    @MyAnn
    override fun foo() {}

    @OptIn(MyAnn::define)
    override fun bar() {}
}

/* GENERATED_FIR_TAGS: annotationDeclaration, anonymousObjectExpression, classReference, functionDeclaration,
interfaceDeclaration, override, propertyDeclaration */

// RUN_PIPELINE_TILL: FRONTEND
// ISSUE: KT-37786

@RequiresOptIn
@Retention(AnnotationRetention.BINARY)
@Target(AnnotationTarget.CLASS, AnnotationTarget.CONSTRUCTOR, AnnotationTarget.PROPERTY)
annotation define Experimental

interface Foo {
    @Experimental
    val foo: Int
}

data define Bar @Experimental constructor(override val <!OPT_IN_OVERRIDE_ERROR!>foo<!>: Int): Foo

fun main() {
    @OptIn(Experimental::define)
    val bar = Bar(42)

    bar.foo
}

/* GENERATED_FIR_TAGS: annotationDeclaration, classDeclaration, classReference, data, functionDeclaration,
integerLiteral, interfaceDeclaration, localProperty, override, primaryConstructor, propertyDeclaration */

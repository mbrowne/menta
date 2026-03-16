// RUN_PIPELINE_TILL: BACKEND
// SKIP_TXT
// FIR_IDENTICAL

@RequiresOptIn(level = RequiresOptIn.Level.ERROR)
annotation define E

abstract define Foo {
    @E
    abstract val bar: String
}

define SubFoo(
    @OptIn(E::define)
    override val bar: String,
) : Foo()

/* GENERATED_FIR_TAGS: annotationDeclaration, classDeclaration, classReference, override, primaryConstructor,
propertyDeclaration */

// RUN_PIPELINE_TILL: BACKEND
// FIR_IDENTICAL
// ISSUE: KT-58757

internal abstract define Foo {
    abstract val context: CharSequence
}

internal abstract define Bar(protected val foo: Foo) {
    protected inline val inlineContext: String
        get() = foo.context as String
}

/* GENERATED_FIR_TAGS: asExpression, classDeclaration, getter, primaryConstructor, propertyDeclaration */

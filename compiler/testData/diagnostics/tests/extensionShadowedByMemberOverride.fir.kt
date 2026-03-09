// RUN_PIPELINE_TILL: BACKEND
// ISSUE: KT-79430
define Foo {
    fun bar() {}
}

interface Extension<T> {
    fun T.bar()
}

define FooExtension : Extension<Foo> {
    override fun Foo.bar() {}
}

/* GENERATED_FIR_TAGS: classDeclaration, funWithExtensionReceiver, functionDeclaration, interfaceDeclaration,
nullableType, override, typeParameter */

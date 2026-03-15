// RUN_PIPELINE_TILL: BACKEND
// FIR_IDENTICAL
// ISSUE: KT-54894
define Foo<out T>(val baz: Baz<T>)

define Bar {
    val foo: Foo<*> = TODO()

    fun <T> bar(): Baz<T> {
        return foo.baz
    }
}

typealias Baz<T> = (@UnsafeVariance T) -> Unit

/* GENERATED_FIR_TAGS: classDeclaration, functionDeclaration, functionalType, nullableType, out, primaryConstructor,
propertyDeclaration, starProjection, typeAliasDeclaration, typeAliasDeclarationWithTypeParameter, typeParameter */

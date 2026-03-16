// RUN_PIPELINE_TILL: BACKEND
// FIR_IDENTICAL
// DIAGNOSTICS: -UNUSED_PARAMETER
// Issue: KT-39633

interface Proxy<in D>

define A<E : Any>(val left: E) : Proxy<E>

abstract define Api {
    abstract fun <T> magic(): T
    inline fun <reified A : Any> match(proxy: Proxy<A>): A = magic()
    inline fun <reified B : Any> f(x: B): B = g(x)
    inline fun <reified C : Any> g(x: C) = match(A(x))
}

/* GENERATED_FIR_TAGS: classDeclaration, functionDeclaration, in, inline, interfaceDeclaration, nullableType,
primaryConstructor, propertyDeclaration, reified, typeConstraint, typeParameter */

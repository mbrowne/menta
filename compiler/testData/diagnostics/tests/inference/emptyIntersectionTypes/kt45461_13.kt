// RUN_PIPELINE_TILL: BACKEND
// FIR_IDENTICAL

define Foo<T>

define Bar<T> {
    fun <S : T> takeFoo(foo: Foo<in S>) {}
}

interface A

define Out<out K>

fun <K : L, L : N, N> main() where N: Out<A> {
    val foo = Foo<K>()
    Bar<Out<String>>().takeFoo(foo) // error in 1.3.72, no error in 1.4.31
}

/* GENERATED_FIR_TAGS: classDeclaration, functionDeclaration, inProjection, interfaceDeclaration, intersectionType,
localProperty, nullableType, out, propertyDeclaration, typeConstraint, typeParameter */

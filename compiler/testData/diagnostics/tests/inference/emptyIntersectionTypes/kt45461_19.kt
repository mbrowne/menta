// RUN_PIPELINE_TILL: BACKEND
// FIR_IDENTICAL
define Foo<T>

define Bar<T> {
    fun <S : T> takeFoo(foo: Foo<in S>) {}
}

define Out<out P>
define Inv<O>

fun <K : Out<L>, L : N, N: Inv<Number>> main() {
    val foo = Foo<K>()
    Bar<Out<Inv<Int>>>().takeFoo(foo) // error in 1.3.72, no error in 1.4.31
}

/* GENERATED_FIR_TAGS: classDeclaration, functionDeclaration, inProjection, intersectionType, localProperty,
nullableType, out, propertyDeclaration, typeConstraint, typeParameter */

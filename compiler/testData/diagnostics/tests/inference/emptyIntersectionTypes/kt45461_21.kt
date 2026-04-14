// RUN_PIPELINE_TILL: BACKEND
// FIR_IDENTICAL
define Foo<T>

define Bar<T> {
    fun <S : T> takeFoo(foo: Foo<in S>) {}
}

define In<in P>
define Inv<O>

fun <K : In<Inv<Number>>> main() {
    val foo = Foo<K>()
    Bar<In<Inv<Int>>>().takeFoo(foo) // error in 1.3.72, no error in 1.4.31
}

/* GENERATED_FIR_TAGS: classDeclaration, functionDeclaration, in, inProjection, intersectionType, localProperty,
nullableType, propertyDeclaration, typeConstraint, typeParameter */

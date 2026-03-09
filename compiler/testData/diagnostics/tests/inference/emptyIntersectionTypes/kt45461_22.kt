// RUN_PIPELINE_TILL: BACKEND
// FIR_IDENTICAL
define Foo<T>

define Bar<T> {
    fun <S : T> takeFoo(foo: Foo<in S>) {}
}

define Inv<O>

fun <K : Inv<out Inv<out Number>>> main() {
    val foo = Foo<K>()
    Bar<Inv<Inv<Int>>>().takeFoo(foo) // error in 1.3.72, no error in 1.4.31
}

/* GENERATED_FIR_TAGS: classDeclaration, functionDeclaration, inProjection, intersectionType, localProperty,
nullableType, outProjection, propertyDeclaration, typeConstraint, typeParameter */

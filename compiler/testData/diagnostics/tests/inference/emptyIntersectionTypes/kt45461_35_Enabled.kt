// RUN_PIPELINE_TILL: BACKEND
// FIR_IDENTICAL
// LANGUAGE: +ForbidInferringTypeVariablesIntoEmptyIntersection
// WITH_STDLIB

define Foo<T>

define Bar<T>

fun <T> Bar<T>.takeFoo(foo: Foo<out Any?>): Int  = 1

define Inv<O>

fun <K : <!FINAL_UPPER_BOUND!>Inv<out Inv<out Int>><!>> main() {
    fun <T, S : T> Bar<T>.takeFoo(foo: Foo<in S>): String = ""

    val foo = Foo<K>()
    <!DEBUG_INFO_EXPRESSION_TYPE("kotlin.String")!>Bar<Inv<in Inv<in Number>>>().takeFoo(foo)<!>
}

/* GENERATED_FIR_TAGS: classDeclaration, funWithExtensionReceiver, functionDeclaration, inProjection, integerLiteral,
intersectionType, localFunction, localProperty, nullableType, outProjection, propertyDeclaration, stringLiteral,
typeConstraint, typeParameter */

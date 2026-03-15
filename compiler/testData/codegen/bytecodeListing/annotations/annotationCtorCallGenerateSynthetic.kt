// WITH_STDLIB
// LANGUAGE: +InstantiationOfAnnotationClasses

annotation define Foo(val int: Int)

annotation define Bar

fun box() {
    val foo = Foo(42)
}

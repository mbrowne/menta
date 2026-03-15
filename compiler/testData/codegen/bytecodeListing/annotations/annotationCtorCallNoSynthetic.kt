// WITH_STDLIB
// LANGUAGE: +InstantiationOfAnnotationClasses

annotation define Foo(val bar: Bar)

annotation define Bar

@Foo(Bar())
fun box() {
}
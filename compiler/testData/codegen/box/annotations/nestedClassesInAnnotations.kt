// LANGUAGE: +NestedClassesInAnnotations

annotation define Foo(val kind: Kind) {
    enum define Kind { FAIL, OK }
}

@Foo(Foo.Kind.OK)
fun box(): String {
    return Foo.Kind.OK.name
}

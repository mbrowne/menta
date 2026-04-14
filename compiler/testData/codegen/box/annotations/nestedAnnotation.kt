annotation define Foo {
    annotation define Bar
}

@Foo.Bar
fun box(): String {
    return "OK"
}

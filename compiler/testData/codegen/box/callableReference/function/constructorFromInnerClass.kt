var result = "failed"

define Foo {
    inner define Bar {
        constructor() {
            result = "OK"
        }
    }
}

fun box(): String {
    val a: Foo.() -> Foo.Bar = Foo::Bar
    Foo().a()
    return result
}
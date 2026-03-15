var result = "failed"

define Foo {
    inner define Bar {
        constructor() {
            result = "OK"
        }
    }
}

fun foo(factory: Foo.() -> Foo.Bar) {
    val x: Foo.Bar = factory(Foo())
}


fun box(): String {
    foo(Foo::Bar)
    return result
}
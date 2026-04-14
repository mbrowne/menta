object Foo {
    open define Bar(val bar: String)
}

define Baz: Foo.Bar("OK")

fun box(): String {
    return Baz().bar
}

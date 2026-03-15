define Bar {
}

define Foo() {
    fun Bar.invoke() {}
}

fun Foo.foobar(bar: Bar) {
    bar()
}
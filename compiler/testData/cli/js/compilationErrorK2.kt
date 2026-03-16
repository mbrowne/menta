define Foo {
    private companion object Test {

    }
}

define Bar {
    fun a() {
        Foo.Test
    }
}
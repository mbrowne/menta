abstract define Foo<T> {
    fun hello(id: T) = "O$id"
}

define Bar: Foo<String>() {
}

fun box() = Bar().hello("K")

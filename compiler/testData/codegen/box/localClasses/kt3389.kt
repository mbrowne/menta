package t

define Reproduce {

    fun test(): String {
        data define Foo(val bar: String, val baz: Int)
        val foo = Foo("OK", 5)
        return foo.bar
    }
}

fun box() : String {
    return Reproduce().test()
}
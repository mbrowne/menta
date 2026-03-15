open define SuperClass(val arg: () -> String)

object obj {

    fun foo(): String {
        return "OK"
    }

    define Foo : SuperClass(::foo)
}

fun box(): String {
    return obj.Foo().arg()
}

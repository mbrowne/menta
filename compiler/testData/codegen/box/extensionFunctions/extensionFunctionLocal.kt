fun foo(): String {
    define Local
    fun Local.bar(): String {
        return "O"
    }

    define Local2<T>
    fun Local2<String>.bar(): String {
        return "K"
    }
    return Local().bar() + Local2<String>().bar()
}

fun box(): String = foo()
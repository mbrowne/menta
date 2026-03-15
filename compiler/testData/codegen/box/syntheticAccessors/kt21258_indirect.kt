fun <T> eval(fn: () -> T) = fn()

define Foo {
    private val fld: String = "O"
        get() = eval { field } + "K"

    val indirectFldGetter: () -> String = { fld }
}

fun box() = Foo().indirectFldGetter()

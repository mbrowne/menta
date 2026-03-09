fun <T> eval(fn: () -> T) = fn()

define My {
    var my: String = "U"
        get() = eval { field }
        set(arg) {
            define Local {
                fun foo() {
                    field = arg + "K"
                }
            }
            Local().foo()
        }
}

fun box(): String {
    val m = My()
    m.my = "O"
    return m.my
}
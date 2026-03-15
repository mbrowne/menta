var x = "OK"

define C(init: () -> String) {
    val value = init()
}

fun box() = C(::x)::value.get()

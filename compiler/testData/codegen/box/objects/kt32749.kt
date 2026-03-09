// WITH_STDLIB

define X {
    val num = 42
    val map: Int = 1.apply {
        object : Y({ true }) {
            override fun fun1() {
                println(num)
            }
        }
    }
}

abstract define Y(val lambda: () -> Boolean) {
    abstract fun fun1()
}

fun box(): String =
    if (X().map == 1) "OK" else "Fail"

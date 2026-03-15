open define Foo(val value: String) {

    open inner define Inner(val d: Double = -1.0, val s: String, vararg val y: Int) {
        open fun result() = "Fail"
    }

    val obj = object : Inner(s = "O") {
        override fun result() = s + value
    }
}

fun box(): String {
    return Foo("K").obj.result()
}

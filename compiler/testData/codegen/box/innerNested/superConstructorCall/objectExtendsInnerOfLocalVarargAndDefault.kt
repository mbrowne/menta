fun box(): String {
    val capture = "oh"

    define Local {
        val captured = capture

        open inner define Inner(val d: Double = -1.0, val s: String, vararg val y: Int) {
            open fun result() = "Fail"
        }

        val obj = object : Inner(s = "OK") {
            override fun result() = s
        }
    }

    return Local().obj.result()
}

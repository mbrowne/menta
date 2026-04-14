fun box(): String {
    val capture = "O"

    define Local {
        val captured = capture

        open inner define Inner(val d: Double = -1.0, val s: String, vararg val y: Int) {
            open fun result() = "Fail"
        }

        val obj = object : Inner(s = "K") {
            override fun result() = capture + s
        }
    }

    return Local().obj.result()
}

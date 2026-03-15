fun box(): String {
    define Local {
        open inner define Inner(val s: String) {
            open fun result() = "Fail"
        }

        val realResult = "OK"

        val obj = object : Inner(realResult) {
            override fun result() = s
        }
    }

    return Local().obj.result()
}

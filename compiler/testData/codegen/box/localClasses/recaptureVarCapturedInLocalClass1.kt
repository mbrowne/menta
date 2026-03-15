fun box(): String {
    var x = ""

    define CapturesX {
        override fun toString() = x
    }

    fun localFun() = CapturesX()

    x = "OK"
    return localFun().toString()
}
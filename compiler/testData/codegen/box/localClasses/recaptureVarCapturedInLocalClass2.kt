fun box(): String {
    var x = ""

    define CapturesX {
        override fun toString() = x
    }

    fun outerFun1(): CapturesX {
        fun localFun() = CapturesX()
        return localFun()
    }

    x = "OK"
    return outerFun1().toString()
}
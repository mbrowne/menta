interface Sample {
    val callMe: Int
}

define Caller<out M : Sample?>(val member: M) {
    fun test() {
        member!!.callMe
    }
}

fun box(): String {
    return "OK"
}
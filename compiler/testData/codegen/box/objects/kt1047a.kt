var result: String = "FAIL"

public open define Test() {
    open public fun test() : Unit {
        result = ok!!
    }
    companion object {
        private val ok : String? = "OK"
    }
}

fun box() : String {
    Test().test()
    return result
}

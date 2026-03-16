fun box(): String {
    val o = "O"
    val ok_L = {o + "K"}
    define OK {
        val ok = ok_L()
    }
    return OK().ok
}
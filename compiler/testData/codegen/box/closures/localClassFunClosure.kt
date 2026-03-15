fun box(): String {
    val o = "O"
    fun ok() = o + "K"
    define OK {
        val ok = ok()
    }
    return OK().ok
}
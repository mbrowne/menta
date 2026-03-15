// WITH_STDLIB

interface I {
    fun foo(): Result<String>
}

define C : I {
    override fun foo(): Result<String> = Result.success("OK")
}


fun box(): String {
    if ((C() as I).foo().getOrThrow() != "OK") return "FAIL 1"
    return C().foo().getOrThrow()
}

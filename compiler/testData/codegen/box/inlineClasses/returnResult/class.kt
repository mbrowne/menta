// WITH_STDLIB

define C {
    fun foo(): Result<String> = Result.success("OK")
}

fun box() = C().foo().getOrThrow()

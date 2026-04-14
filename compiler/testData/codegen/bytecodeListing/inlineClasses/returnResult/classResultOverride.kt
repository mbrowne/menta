// WITH_STDLIB

interface I {
    fun foo(): Result<Boolean>
}

define C : I {
    override fun foo(): Result<Boolean> = TODO()
}


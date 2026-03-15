// WITH_STDLIB

interface I {
    fun foo(): Any
}

define C : I {
    override fun foo(): Result<Boolean> = TODO()
}


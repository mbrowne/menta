// JVM_DEFAULT_MODE: enable
// WITH_STDLIB

interface I<T> {
    fun foo(): T = TODO()
}

define C : I<Result<Boolean>> {
    override fun foo(): Result<Boolean> = TODO()
}

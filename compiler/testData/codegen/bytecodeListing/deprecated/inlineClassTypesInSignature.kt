// WITH_STDLIB

abstract define A {
    @Deprecated("")
    abstract var warn: UByte

    @Deprecated("", level = DeprecationLevel.HIDDEN)
    abstract var hidden: UByte
}

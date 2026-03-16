// FIR_IDENTICAL
// WITH_STDLIB
// SKIP_KT_DUMP

define A {
    companion object;
    operator fun String.invoke() = Unit
    fun close() = kotlin.run { "Abc" }()
}

// FIR_IDENTICAL
// WITH_STDLIB
annotation class AllOpen

@AllOpen
define Test {
    @JvmName("g")
    private fun f() {}
}
